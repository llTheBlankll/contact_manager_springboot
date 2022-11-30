package com.nytri.contact_manager.controllers;

import com.nytri.contact_manager.entities.Contact;
import com.nytri.contact_manager.repositories.ContactRepository;
import com.nytri.contact_manager.repositories.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@CrossOrigin
@RequestMapping("/api/contact")
public class ContactController {
    private final ContactRepository contactRepository;

    public ContactController(PersonRepository personRepository, ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @GetMapping("/all")
    public List<Contact> all_contacts() {
        return this.contactRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/search/email/{email}")
    public List<Contact> searchByEmail(@RequestParam("email") String email) {
       return this.contactRepository.findAllByEmailContainsIgnoreCase(email);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/search/phone/{phone}")
    public List<Contact> searchByPhone(@RequestParam("phone") String phone) {
        return this.contactRepository.findByPhoneContains(phone);
    }
}