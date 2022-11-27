package com.nytri.contact_manager.repositories;

import com.nytri.contact_manager.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
