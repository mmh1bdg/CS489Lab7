package edu.miu.cs.cs489.lab7.adsdentalsurgery.repository;

import edu.miu.cs.cs489.lab7.adsdentalsurgery.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    List<Patient> findAllByOrderByLastNameAsc();

    List<Patient> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String firstName, String lastName);

}
