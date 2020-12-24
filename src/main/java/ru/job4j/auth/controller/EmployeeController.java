package ru.job4j.auth.controller;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.job4j.auth.domain.Employee;
import ru.job4j.auth.domain.Person;
import ru.job4j.auth.repository.EmployeeRepository;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/employee/")
public class EmployeeController {
    private final EmployeeRepository employeeRepository;
    private final RestTemplate rest;

    private static final String PERSON_API = "http://localhost:8080/person/";
    private static final String PERSON_API_ID = "http://localhost:8080/person/{id}";

    public EmployeeController(EmployeeRepository employeeRepository, RestTemplate rest) {
        this.employeeRepository = employeeRepository;
        this.rest = rest;
    }

    @GetMapping("/")
    public Collection<Employee> findAll() {
        Map<Integer, Employee> employees = StreamSupport.stream(
                employeeRepository.findAll().spliterator(), false)
                .collect(Collectors.toMap(
                        Employee::getId, employee -> employee));
        List<Person> personList = rest.exchange(
                PERSON_API,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Person>>() {
                }).getBody();
        personList.forEach(person ->
                employees.get(person.getEmployee().getId())
                        .addPerson(person));
        return employees.values();
    }

    @PostMapping("/")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeRepository.save(employee),
                HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<Void> updateEmployee(@RequestBody Employee employee) {
        employeeRepository.save(employee);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
        employeeRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
