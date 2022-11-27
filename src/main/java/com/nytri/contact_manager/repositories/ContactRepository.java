package com.nytri.contact_manager.repositories;

import com.nytri.contact_manager.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
