package edu.miu.cs.cs489.lab7.adsdentalsurgery.service.impl;

import edu.miu.cs.cs489.lab7.adsdentalsurgery.model.Address;
import edu.miu.cs.cs489.lab7.adsdentalsurgery.model.Patient;
import edu.miu.cs.cs489.lab7.adsdentalsurgery.repository.AddressRepository;
import edu.miu.cs.cs489.lab7.adsdentalsurgery.repository.PatientRepository;
import edu.miu.cs.cs489.lab7.adsdentalsurgery.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final AddressRepository addressRepository;

    public PatientServiceImpl(PatientRepository patientRepository, AddressRepository addressRepository) {
        this.patientRepository = patientRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public Patient save(Patient patient) {
        Address processedAddress = handleAddress(patient.getAddress());
        patient.setAddress(processedAddress);
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> findAllSortedByLastName() {
        return patientRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Optional<Patient> findById(Long id) {
        return patientRepository.findById(id);
    }

    @Override
    public Patient createPatient(Patient patient) {
        Address processedAddress = handleAddress(patient.getAddress());
        patient.setAddress(processedAddress);
        return patientRepository.save(patient);
    }

    @Override
    public Patient updatePatient(Long id, Patient updatedPatient) {
        Address processedAddress = handleAddress(updatedPatient.getAddress());

        return patientRepository.findById(id).map(existing -> {
            existing.setFirstName(updatedPatient.getFirstName());
            existing.setLastName(updatedPatient.getLastName());
            existing.setAddress(processedAddress);
            return patientRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
    }

    @Override
    public void deletePatient(Long id) {
        if (!patientRepository.existsById(id)) {
            throw new RuntimeException("Patient not found with id: " + id);
        }
        patientRepository.deleteById(id);
    }

    @Override
    public List<Patient> searchPatients(String name) {
        return patientRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(name, name);
    }

    // Helper method to persist or fetch existing address
    private Address handleAddress(Address address) {
        if (address == null) return null;

        if (address.getId() != null) {
            return addressRepository.findById(address.getId())
                    .orElseThrow(() -> new RuntimeException("Address not found with id: " + address.getId()));
        } else {
            return addressRepository.save(address);
        }
    }
}
