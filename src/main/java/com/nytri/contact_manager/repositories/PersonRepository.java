package com.nytri.contact_manager.repositories;

import com.nytri.contact_manager.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person findByFirstNameContaining(String fname);
    Person findByLastNameContaining(String lname);
    Person findByBirthdate(LocalDate birthdate);
    Person findByBirthdateBetween(LocalDate birthdate, LocalDate birthdate2);
}
