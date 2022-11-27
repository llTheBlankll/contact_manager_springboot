package com.nytri.contact_manager.controllers;

import com.nytri.contact_manager.entities.Contact;
import com.nytri.contact_manager.entities.Person;
import com.nytri.contact_manager.repositories.ContactRepository;
import com.nytri.contact_manager.repositories.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @RequestMapping(method = RequestMethod.GET, path = "/search_people/by_firstName/{first_name}")
    public Person search_person_by_firstname(@RequestParam("first_name") String first_name) {
        return this.personRepository.findByFirstNameContaining(first_name);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/search_people/by_lastName/{last_name}")
    public Person search_person_by_lastname(@RequestParam("last_name") String last_name) {
        return this.personRepository.findByLastNameContaining(last_name);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/search_people/by_birthday/{date}")
    public Person search_person_by_birthdate(@RequestParam("date") LocalDate date) {
        return this.personRepository.findByBirthdate(date);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/search_people/by_birthday_between/{fromDate}/{toDate}")
    public Person find_people_by_birthdate(@RequestParam("fromDate") LocalDate fromDate, @RequestParam("toDate") LocalDate toDate) {
        return this.personRepository.findByBirthdateBetween(fromDate, toDate);
    }
}
