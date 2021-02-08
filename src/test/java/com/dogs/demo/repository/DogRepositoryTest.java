//package com.dogs.demo.repository;
//
//import com.dogs.demo.entity.Dog;
//import org.hamcrest.Matchers;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import javax.persistence.EntityManager;
//import javax.sql.DataSource;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//
//@ExtendWith(SpringExtension.class)
//@DataJpaTest
//class DogRepositoryTest {
//
//    @Autowired
//    private EntityManager entityManager;
//    @Autowired
//    private DogRepository dogRepository;
//
//    @Test
//    void findBreedById() {
//        Dog dog = new Dog("name", "breed", "origin");
//
//        entityManager.persist(dog);
//
//        String result = dogRepository.findBreedById(dog.getId());
//
//        assertEquals(dog.getBreed(), result);
//    }
//
//    @Test
//    void findAllBreed() {
//        Dog dog1 = new Dog("Name 1", "Breed 1");
//        Dog dog2 = new Dog("Name 4", "Breed 3");
//        Dog dog3 = new Dog("Name 3", "Breed 4");
//        List<String> breeds = new ArrayList<>();
//        breeds.add(dog1.getBreed());
//        breeds.add(dog2.getBreed());
//        breeds.add(dog3.getBreed());
//
//        entityManager.persist(dog1);
//        entityManager.persist(dog2);
//        entityManager.persist(dog3);
//
//        List<String> actualBreeds = dogRepository.findAllBreed();
//
//
//        assertThat(actualBreeds, Matchers.containsInAnyOrder(breeds.toArray()));
//    }
//
//
//    @Test
//    void findAllName() {
//        Dog dog1 = new Dog("Name 1", "Breed 1");
//        Dog dog2 = new Dog("Name 4", "Breed 3");
//        Dog dog3 = new Dog("Name 3", "Breed 4");
//        List<String> names = new ArrayList<>();
//        names.add(dog1.getName());
//        names.add(dog2.getName());
//        names.add(dog3.getName());
//
//        entityManager.persist(dog1);
//        entityManager.persist(dog2);
//        entityManager.persist(dog3);
//
//        List<String> actualNames = dogRepository.findAllName();
//
//        assertThat(actualNames, Matchers.containsInAnyOrder(names.toArray()));
//    }
//}