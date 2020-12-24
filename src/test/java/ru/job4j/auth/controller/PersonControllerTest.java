package ru.job4j.auth.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.auth.AuthApplication;
import ru.job4j.auth.domain.Person;
import ru.job4j.auth.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
@AutoConfigureMockMvc
class PersonControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @MockBean
//    private PersonRepository personRepository;
//
//    @Test
//    void findAll() throws Exception {
//        List<Person> personList = new ArrayList<>();
//        personList.add(new Person("Ivan", "123"));
//        personList.add(new Person("Alex", "432"));
//
//        given(personRepository.findAll()).willReturn(personList);
//
//        this.mockMvc.perform(get("/person/"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().json(objectMapper.writeValueAsString(personList)));
//    }
//
//    @Test
//    void findById() throws Exception {
//        Person person = new Person("Ivan", "123");
//        person.setId(2);
//
//        given(personRepository.findById(2)).willReturn(java.util.Optional.of(person));
//
//        this.mockMvc.perform(get("/person/2"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().json(objectMapper.writeValueAsString(person)));
//    }
//
//    @Test
//    void create() throws Exception {
//        Person person = new Person("Ivan", "123");
//
//        given(personRepository.save(person)).willReturn(person);
//
//        this.mockMvc.perform(post("/person/")
//                .contentType("application/json")
//                .content(objectMapper.writeValueAsString(person)))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful())
//                .andExpect(content().json(objectMapper.writeValueAsString(person)));
//
//    }
//
//    @Test
//    void update() throws Exception {
//        Person person = new Person("Alex", "432");
//        this.mockMvc.perform(put("/person/")
//                .contentType("application/json")
//                .content(objectMapper.writeValueAsString(person)))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//
//        ArgumentCaptor<Person> personArgumentCaptor = ArgumentCaptor.forClass(Person.class);
//        verify(personRepository).save(personArgumentCaptor.capture());
//
//        assertEquals(person.getLogin(), personArgumentCaptor.getValue().getLogin());
//    }
}