package com.nytri.contact_manager.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id", nullable = false)
    private Integer id;

    @Column(name = "first_name", length = 128)
    private String firstName;

    @Column(name = "last_name", length = 128)
    private String lastName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Contact contact;

    public Person(Integer id, String firstName, String lastName, Integer age, LocalDate birthdate, Contact contact) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.birthdate = birthdate;
        this.contact = contact;
    }

    public Person() {

    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Person(Contact contact) {
        this.contact = contact;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

}