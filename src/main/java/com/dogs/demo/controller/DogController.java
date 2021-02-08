package com.dogs.demo.controller;

import com.dogs.demo.entity.Dog;
import com.dogs.demo.service.DogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DogController {

    private static final Logger log = LoggerFactory.getLogger(DogController.class);

    private DogService dogService;

    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping("/dogs")
    public ResponseEntity<List<Dog>> getAllDogs() {
        List<Dog> dogs = dogService.retrieveDogs();
        log.info("There are " + dogs.size() + " in the database");
        return new ResponseEntity<>(dogs, HttpStatus.OK);
    }

    @GetMapping("/dogs/breed")
    public ResponseEntity<List<String>> getDogBreeds() {
        List<String> breeds = dogService.retrieveDogBreed();
        return new ResponseEntity<>(breeds, HttpStatus.OK);
    }

    @GetMapping("{id}/breed")
    public ResponseEntity<String> getBreedByID(@PathVariable Long id) {
        String breed = dogService.retrieveDogBreedById(id);
        return new ResponseEntity<>(breed, HttpStatus.OK);
    }

    @GetMapping("/dogs/name")
    public ResponseEntity<List<String>> getDogNames() {
        List<String> names = dogService.retrieveDogNames();
        return new ResponseEntity<>(names, HttpStatus.OK);
    }


}
