package com.example.Employee.Management.System.personDetails.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "health")
public abstract class Health {

    @Id
    @Column(name = "personId", nullable = false, updatable = false)
    private Long personId;

    @NotBlank(message = "Blood group cannot be blank")
    @Column(name = "blood_group", nullable = false, updatable = false)
    private String bloodGroup;

    @NotNull(message = "Health conditions cannot be null")
    @Column(name = "health_conditions", nullable = false, updatable = false)
    private List<String> healthCondition;

    Health() {
        super();
    }

    public Health(final Long personId,
                  final String bloodGroup,
                  final List<String> healthCondition) {
        this();
        setPersonId(personId);
        setBloodGroup(bloodGroup);
        setHealthCondition(healthCondition);
    }

    /**
     * Get the personId for which the health details are being stored
     *
     * @return the personId for which the health details are being stored
     */
    public Long getPersonId() {
        return personId;
    }

    /**
     * Get the blood group of the person
     *
     * @return the blood group of the person
     */
    public String getBloodGroup() {
        return bloodGroup;
    }

    /**
     * Get the list of health conditions of the person
     *
     * @return the list of health conditions of the person
     */
    public List<String> getHealthCondition() {
        return new ArrayList<>(this.healthCondition);
    }

    /**
     * Adds sent health condition to the list of health condition that the person has
     *
     * @param healthCondition is the health condition that needs to be added to the list of health conditions the person has
     *
     * @return the changed list of health conditions that the person has
     */
    public List<String> addHealthCondition(final String healthCondition){
        this.healthCondition.add(healthCondition);

        return new ArrayList<>(this.healthCondition);
    }

    // Setter for personId with no validation as it's an identifier and should not be changed programmatically
    public void setPersonId(final Long personId) {
        this.personId = personId;
    }

    public void setBloodGroup(final String bloodGroup) {
        // Perform validation for blood group
        if (bloodGroup == null || bloodGroup.trim().isEmpty()) {
            throw new IllegalArgumentException("Blood group cannot be null or empty");
        }
        this.bloodGroup = bloodGroup.trim();
    }

    public void setHealthCondition(final List<String> healthCondition) {
        // Perform validation for health condition list
        if (healthCondition == null || healthCondition.isEmpty()) {
            throw new IllegalArgumentException("Health conditions cannot be null or empty");
        }
        this.healthCondition = new ArrayList<>(healthCondition);
    }
}
