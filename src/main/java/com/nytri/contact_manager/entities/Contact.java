package com.nytri.contact_manager.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id", nullable = false)
    private Integer id;

    @Column(name = "person_id")
    private Integer personId;

    @Column(name = "phone", length = 128)
    private String phone;

    @Column(name = "email", length = 128)
    private String email;

    @Column(name = "significant_date")
    private LocalDate significantDate;

    @Column(name = "significant_date_label", length = 128)
    private String significantDateLabel;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "contact")
    private Person relatedPersonId;

    @Column(name = "related_person_relationship", length = 128)
    private String relatedPersonRelationship;

    public Contact() {

    }

    public Contact(Integer id, Integer personId, String phone, String email, LocalDate significantDate, String significantDateLabel, Person relatedPersonId, String relatedPersonRelationship) {
        this.id = id;
        this.personId = personId;
        this.phone = phone;
        this.email = email;
        this.significantDate = significantDate;
        this.significantDateLabel = significantDateLabel;
        this.relatedPersonId = relatedPersonId;
        this.relatedPersonRelationship = relatedPersonRelationship;
    }

    public Person getRelatedPersonId() {
        return relatedPersonId;
    }

    public void setRelatedPersonId(Person relatedPersonId) {
        this.relatedPersonId = relatedPersonId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getSignificantDate() {
        return significantDate;
    }

    public void setSignificantDate(LocalDate significantDate) {
        this.significantDate = significantDate;
    }

    public String getSignificantDateLabel() {
        return significantDateLabel;
    }

    public void setSignificantDateLabel(String significantDateLabel) {
        this.significantDateLabel = significantDateLabel;
    }

    public String getRelatedPersonRelationship() {
        return relatedPersonRelationship;
    }

    public void setRelatedPersonRelationship(String relatedPersonRelationship) {
        this.relatedPersonRelationship = relatedPersonRelationship;
    }

}