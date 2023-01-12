package com.youcode.mypet.Controller;

import com.youcode.mypet.DTO.AnimalDTO;
import com.youcode.mypet.DTO.mapper.IMapperDto;
import com.youcode.mypet.Entity.AnimalEntity;
import com.youcode.mypet.Request.AnimalRequest;
import com.youcode.mypet.Service.AnimalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "*")
public class AnimalController {

    @Autowired
    AnimalService animalService;

    @PostMapping("/animal/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@PathVariable String id, @RequestBody @Valid AnimalRequest animalRequest) throws Exception {
        animalService.createAnimal(animalRequest, Long.parseLong(id));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/animals/{id}")
    public void delete(@PathVariable String id) throws Exception {
        animalService.deleteAnimal(Long.parseLong(id));
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/animals/{id}")
    public void update(@PathVariable String id, @RequestBody @Valid AnimalRequest animalRequest) throws Exception {
        animalService.updateAnimal(Long.parseLong(id), animalRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/animals/{id}")
    public AnimalDTO getOne(@PathVariable String id) throws Exception {
        return animalService.getOneAnimal(Long.parseLong(id));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/animals")
    public List<AnimalDTO> getAll(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "limit", defaultValue = "8") int limit) {
        return animalService.getAllAnimals(page, limit);
    }
}