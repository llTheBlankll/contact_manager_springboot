package com.nytri.contact_manager.repositories;

import com.nytri.contact_manager.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

    List<Contact> findAllByEmailContainsIgnoreCase(String email);
    List<Contact> findByPhoneContains(String phone);
}
