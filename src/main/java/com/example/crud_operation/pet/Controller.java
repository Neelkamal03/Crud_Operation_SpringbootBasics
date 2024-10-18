package com.example.crud_operation.pet;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/pets")
public class Controller {
    private PetService petService;

    @GetMapping("/all")
    public ResponseEntity<List<Pet>> getPets(){
        return new ResponseEntity<>(petService.getPets(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Pet> add(@RequestBody Pet pet){
        return new ResponseEntity<>(petService.add(pet), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Pet> update(@RequestBody Pet pet){
        return new ResponseEntity<>(petService.update(pet),HttpStatus.CREATED);
    }

    @DeleteMapping("/pet/{id}")
    public void delete(@PathVariable("id") Integer id){
        petService.delete(id);
    }

    @GetMapping("/pet/{id}")
    public ResponseEntity<Optional<Pet>> getPetById(@PathVariable Integer id){
        try {
            return new ResponseEntity<>(petService.getById(id), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}
