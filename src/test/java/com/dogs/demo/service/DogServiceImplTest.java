package com.dogs.demo.service;

import com.dogs.demo.entity.Dog;
import com.dogs.demo.repository.DogRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
class DogServiceImplTest {

    @InjectMocks
    private DogServiceImpl dogService;

    @MockBean
    private DogRepository dogRepository;

    @Test
    void retrieveDogs() {
        List<Dog> dogs = new ArrayList<>();
        Dog dog1 = new Dog("First dog", "The breed 1");
        Dog dog2 = new Dog("Second dog", "The breed 2");
        dogs.add(dog1);
        dogs.add(dog2);

        Mockito.when(dogRepository.findAll()).thenReturn(dogs);

        List<Dog> result = dogService.retrieveDogs();

        assertEquals(dogs, result);
    }

    @Test
    void retrieveDogBreed() {
        List<String> breeds = new ArrayList<>();
        breeds.add("Breed 1");
        breeds.add("Breed 2");

        Mockito.when(dogRepository.findAllBreed()).thenReturn(breeds);

        List<String> result = dogService.retrieveDogBreed();

        assertEquals(breeds, result);
    }

    @Test
    void retrieveDogBreedById() {
        Long id = 1L;
        String breed = "Breed";

        Mockito.when(dogRepository.findBreedById(id)).thenReturn(breed);

        String result = dogService.retrieveDogBreedById(id);

        assertEquals(breed, result);
    }

    @Test
    void retrieveDogNames() {
        List<String> names = new ArrayList<>();
        names.add("Names 1");
        names.add("Names 2");

        Mockito.when(dogRepository.findAllName()).thenReturn(names);

        List<String> result = dogService.retrieveDogNames();

        assertEquals(names, result);
    }
}