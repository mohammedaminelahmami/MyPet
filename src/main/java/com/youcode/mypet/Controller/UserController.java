package com.youcode.mypet.Controller;

import com.youcode.mypet.DTO.AnimalDTO;
import com.youcode.mypet.DTO.UserDTO;
import com.youcode.mypet.Request.AnimalRequest;
import com.youcode.mypet.Request.UserRequest;
import com.youcode.mypet.Service.AnimalService;
import com.youcode.mypet.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserService userService;

//    @PostMapping("/user/{id}")
//    @ResponseStatus(HttpStatus.CREATED)
//    public void save(@PathVariable String id, @RequestBody @Valid AnimalRequest animalRequest) throws Exception {
//        animalService.createAnimal(animalRequest, Long.parseLong(id));
//    }
//
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @DeleteMapping("/users/{id}")
//    public void delete(@PathVariable String id) throws Exception {
//        animalService.deleteAnimal(Long.parseLong(id));
//    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/users/{id}")
    public void update(@PathVariable String id, @RequestBody @Valid UserRequest userRequest) throws Exception {
        userService.updateUser(Long.parseLong(id), userRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/users/{id}")
    public UserDTO getOne(@PathVariable String id) throws Exception {
        return userService.getOneUser(Long.parseLong(id));
    }

//    @ResponseStatus(HttpStatus.OK)
//    @GetMapping("/users")
//    public List<AnimalDTO> getAll(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "limit", defaultValue = "8") int limit) {
//        return animalService.getAllAnimals(page, limit);
//    }
}