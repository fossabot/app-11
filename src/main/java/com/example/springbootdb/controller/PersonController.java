package com.example.springbootdb.controller;

import com.example.springbootdb.entity.Person;
import com.example.springbootdb.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/persons")
public class PersonController {

    PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping(value = "/{id}")
    public Person getPersonById(@PathVariable int id) {
        return this.personService.getPersonById(id);
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return this.personService.createPerson(person);
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    public Person updatePerson(@PathVariable int id, @RequestBody Person person) {
        return  this.personService.updatePerson(id,person);
    }

    @DeleteMapping(value = "/{id}")
    public void deletePerson(@PathVariable int id) {
        this.personService.deletePerson(id);
    }
}
