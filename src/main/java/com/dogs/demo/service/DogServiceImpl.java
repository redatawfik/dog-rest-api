package com.dogs.demo.service;

import com.dogs.demo.entity.Dog;
import com.dogs.demo.repository.DogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DogServiceImpl implements DogService {

    private final DogRepository repository;

    public DogServiceImpl(DogRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Dog> retrieveDogs() {
        return (List<Dog>) repository.findAll();
    }

    @Override
    public List<String> retrieveDogBreed() {
        return repository.findAllBreed();
    }

    @Override
    public String retrieveDogBreedById(Long id) {
        Optional<String> optionalBreed = Optional.ofNullable(repository.findBreedById(id));
        return optionalBreed.orElseThrow(DogNotFoundException::new);
    }

    @Override
    public List<String> retrieveDogNames() {
        return repository.findAllName();
    }
}
