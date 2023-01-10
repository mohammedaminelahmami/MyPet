package com.youcode.mypet.Service;

import com.youcode.mypet.DTO.AnimalDTO;
import com.youcode.mypet.DTO.mapper.IMapperDto;
import com.youcode.mypet.Entity.AnimalEntity;
import com.youcode.mypet.Entity.UserEntity;
import com.youcode.mypet.Repository.AnimalRepository;
import com.youcode.mypet.Repository.UserRepository;
import com.youcode.mypet.Request.AnimalRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {
    @Autowired
    AnimalRepository animalRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    IMapperDto<AnimalDTO, AnimalEntity> mapper;

    public void createAnimal(AnimalRequest animalRequest, Long id) throws Exception {
        try {
            AnimalDTO animalDTO = new AnimalDTO();
            BeanUtils.copyProperties(animalRequest, animalDTO);
            AnimalEntity animal = mapper.convertToEntity(animalDTO, AnimalEntity.class);

            // user foreign key (obj User)
            Optional<UserEntity> user = userRepository.findById(id);

            if(user.isPresent()) {
                animal.setUser(user.get());
            }else{
                throw new Exception("No User Found by this id");
            }

            animalRepository.save(animal);
        }catch (Exception e) {
            throw new Exception("createAnimalCatch");
        }
    }

    public void deleteAnimal(Long id) throws Exception {
        Optional<AnimalEntity> animal = animalRepository.findById(id);
        if(animal.isPresent()) {
            animalRepository.delete(animal.get());
        }else{
            throw new Exception("id not valid");
        }
    }

    public void updateAnimal(Long id, AnimalRequest animalRequest) throws Exception {
        Optional<AnimalEntity> animal = animalRepository.findById(id);

        if(animal.isPresent()) {
            animal.get().setAge(animalRequest.getAge());
            animalRepository.save(animal.get());
        }else {
            throw new Exception("id not valid");
        }
    }

    public AnimalDTO getOneAnimal(Long id) throws Exception {
        Optional<AnimalEntity> animal = animalRepository.findById(id);
        if(animal.isPresent()) {
            AnimalDTO animalDTO = mapper.convertToDTO(animal.get(), AnimalDTO.class);
            return animalDTO;
        }else{
            throw new Exception("id not valid");
        }
    }

    public List<AnimalDTO> getAllAnimals(int page, int limit) {
        if(page > 0) page--;
        List<AnimalEntity> animals = animalRepository.findAll(PageRequest.of(page, limit)).getContent();
        List<AnimalDTO> animalDTOS = mapper.convertListToListDto(animals, AnimalDTO.class);
        return animalDTOS;
    }
}
