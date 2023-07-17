package org.example.services;

import org.example.models.Person;
import org.example.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPersons() {
        return (List<Person>) personRepository.findAll();
    }

    public void printPersons(List<Person> persons) {
        for (Person p : persons) {
            System.out.println(p);
        }
    }
}
