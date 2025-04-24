package edu.miu.cs.cs489.lab7.adsdentalsurgery.service;

import edu.miu.cs.cs489.lab7.adsdentalsurgery.model.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {

    Patient save(Patient newAddress);
    List<Patient> findAllSortedByLastName();
    Optional<Patient> findById(Long id);
    Patient createPatient(Patient patient);
    Patient updatePatient(Long id, Patient updatedPatient);
    void deletePatient(Long id);
    List<Patient> searchPatients(String name);

}
