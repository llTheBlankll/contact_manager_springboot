package com.nytri.contact_manager.controllers;

import com.nytri.contact_manager.entities.Contact;
import com.nytri.contact_manager.entities.Person;
import com.nytri.contact_manager.repositories.ContactRepository;
import com.nytri.contact_manager.repositories.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Controller
@CrossOrigin
@RequestMapping("/api")
public class MainController {

    private final PersonRepository personRepository;
    private final ContactRepository contactRepository;

    public MainController(PersonRepository personRepository, ContactRepository contactRepository) {
        this.personRepository = personRepository;
        this.contactRepository = contactRepository;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/all_people")
    public List<Person> all_people() {
        return this.personRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/all_contacts")
    public List<Contact> all_contacts() {
        return this.contactRepository.findAll();
    }
}
