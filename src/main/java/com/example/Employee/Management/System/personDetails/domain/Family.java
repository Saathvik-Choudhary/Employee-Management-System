package com.example.Employee.Management.System.personDetails.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "family")
public abstract class Family {

    @NotBlank(message = "Father name cannot be blank")
    @Column(name = "father_name", nullable = false, updatable = false)
    private String fatherName;

    @NotBlank(message = "Father contact cannot be blank")
    @Column(name = "father_contact", nullable = false, updatable = false)
    private String fatherContact;

    @NotBlank(message = "Mother name cannot be blank")
    @Column(name = "mother_name", nullable = false, updatable = false)
    private String motherName;

    @NotBlank(message = "Mother contact cannot be blank")
    @Column(name = "mother_contact", nullable = false, updatable = false)
    private String motherContact;

    @Id
    @NotNull(message = "Person ID cannot be null")
    @Column(name = "person_id", nullable = false, updatable = false)
    private Long personId;

    @NotNull(message = "Sibling names list cannot be null")
    @Column(name = "sibling_names", nullable = false)
    private List<String> siblingNames;

    public Family(final Long personId,
                  final String fatherName,
                  final String fatherContact,
                  final String motherName,
                  final String monthContact,
                  final List<String> siblingNames) {
        setFatherName(fatherName);
        setFatherContact(fatherContact);
        setMotherContact(monthContact);
        setMotherName(motherName);
        setPersonId(personId);
        setSiblingNames(siblingNames);
    }

    /**
     * Get the father name of the person
     *
     * @return the father name of the person
     */
    public String getFatherName() {
        return fatherName;
    }

    /**
     * Get father's contact number
     *
     * @return father's contact number
     */
    public String getFatherContact() {
        return fatherContact;
    }

    /**
     * Get mother's name
     *
     * @return mother's name
     */
    public String getMotherName() {
        return motherName;
    }

    /**
     * Get mother's contact number
     *
     * @return mother's contact number
     */
    public String getMotherContact() {
        return motherContact;
    }

    /**
     * Get the person id for which the family object is created
     *
     * @return the person id for which the family object is created
     */
    public Long getPersonId() {
        return personId;
    }

    /**
     * Get the list of sibling names
     *
     * @return the list of sibling names
     */
    public List<String> getSiblingNames() {
        return new ArrayList<>(siblingNames);
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public void setFatherContact(String fatherContact) {
        this.fatherContact = fatherContact;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public void setMotherContact(String motherContact) {
        this.motherContact = motherContact;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public void setSiblingNames(List<String> siblingNames) {
        this.siblingNames = siblingNames;
    }

    public List<String> addSibling(final String siblingName){
        this.siblingNames.add(siblingName);

        return new ArrayList<>(this.siblingNames);
    }
}
