package ru.job4j.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.job4j.auth.domain.Person;
import ru.job4j.auth.domain.Report;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/report")
public class ReportsController {
    @Autowired
    private RestTemplate rest;

    private static final String PERSON_API = "http://localhost:8080/person/";

    private static final String PERSON_API_ID = "http://localhost:8080/person/{id}";

    @GetMapping("/")
    public List<Report> findAll() {
        List<Report> rsl = new ArrayList<>();
        List<Person> persons = rest.exchange(
                PERSON_API,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Person>>() {
                }).getBody();
        persons.forEach(person -> rsl.add(Report.of(1, "first", person)));
        return rsl;
    }

    @PostMapping("/")
    public ResponseEntity<Person> create(@RequestBody Person person) {
        Person rsl = rest.postForObject(PERSON_API, person, Person.class);
        return new ResponseEntity<>(
                rsl,
                HttpStatus.CREATED
        );
    }

    @PutMapping("/")
    public ResponseEntity<Void> update(@RequestBody Person person) {
       rest.put(PERSON_API, person);
       return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        rest.delete(PERSON_API_ID, id);
        return ResponseEntity.ok().build();
    }
}
