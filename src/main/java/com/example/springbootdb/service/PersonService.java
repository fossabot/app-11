package com.example.springbootdb.service;

import com.example.springbootdb.entity.Person;
import com.example.springbootdb.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person getPersonById(int id) {
        return this.personRepository.findById(id).get();
    }

    public Person createPerson(Person person) {
        return this.personRepository.save(person);
    }

    public Person updatePerson(int id,Person person) {
        Optional<Person> personOptional = this.personRepository.findById(id);
        if (personOptional.isPresent()) {
            personOptional.get().setName(person.getName());
            personOptional.get().setVorname(person.getVorname());
            return this.personRepository.save(personOptional.get());
        }
        throw new RuntimeException();
    }

    public void deletePerson(int id) {
        this.personRepository.deleteById(id);
    }
}
