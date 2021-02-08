package com.dogs.demo;

import com.dogs.demo.entity.Dog;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class DogIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getAllDogs() {
        ResponseEntity<List> response =
                this.restTemplate.getForEntity("http://localhost:" + port + "/dogs/", List.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    public void getDogBreeds() {
        ResponseEntity<List> response =
                this.restTemplate.getForEntity("http://localhost:" + port + "/dogs/breed/", List.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    public void getDogNames() {
        ResponseEntity<List> response =
                this.restTemplate.getForEntity("http://localhost:" + port + "/dogs/name/", List.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    public void getBreedByID() {
        ResponseEntity<String> response =
                this.restTemplate.getForEntity("http://localhost:" + port + "/1/breed/", String.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }
}
