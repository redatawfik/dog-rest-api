package com.dogs.demo.service;

import com.dogs.demo.entity.Dog;

import java.util.List;

public interface DogService {
    List<Dog> retrieveDogs();

    List<String> retrieveDogBreed();

    String retrieveDogBreedById(Long id);

    List<String> retrieveDogNames();
}
