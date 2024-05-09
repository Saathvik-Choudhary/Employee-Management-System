package com.example.Employee.Management.System.personDetails.percistence;

import com.example.Employee.Management.System.personDetails.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
}
