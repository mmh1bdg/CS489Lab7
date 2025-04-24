package edu.miu.cs.cs489.lab7.adsdentalsurgery.controller;

import edu.miu.cs.cs489.lab7.adsdentalsurgery.model.Patient;
import edu.miu.cs.cs489.lab7.adsdentalsurgery.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adsweb/api/v1/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    // GET all patients sorted by last name
    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patients = patientService.findAllSortedByLastName();
        return ResponseEntity.ok(patients);
    }

    // GET patient by ID
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        return patientService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // CREATE new patient
    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        Patient created = patientService.createPatient(patient);
        return ResponseEntity.ok(created);
    }

    // UPDATE patient by ID
    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient updatedData) {
        try {
            Patient updated = patientService.updatePatient(id, updatedData);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE patient by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        try {
            patientService.deletePatient(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // SEARCH patients by name
    @GetMapping("/search/{searchString}")
    public ResponseEntity<List<Patient>> searchPatients(@PathVariable String searchString) {
        List<Patient> results = patientService.searchPatients(searchString);
        return ResponseEntity.ok(results);
    }
}
