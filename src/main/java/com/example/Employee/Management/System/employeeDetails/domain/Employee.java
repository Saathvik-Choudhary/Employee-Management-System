package com.example.Employee.Management.System.employeeDetails.domain;

import com.example.Employee.Management.System.personDetails.domain.Person;
import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "employee_id")
    private Long employeeId;

    @OneToOne
    @JoinColumn(name = "person")
    private Person person;

    @Column(name = "department", nullable = false, updatable = false)
    private String department;

    @Column(name = "designation", nullable = false, updatable = false)
    private String designation;

}
