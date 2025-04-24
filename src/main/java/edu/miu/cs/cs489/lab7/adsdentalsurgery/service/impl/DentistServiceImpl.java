package edu.miu.cs.cs489.lab7.adsdentalsurgery.service.impl;

import edu.miu.cs.cs489.lab7.adsdentalsurgery.model.Dentist;
import edu.miu.cs.cs489.lab7.adsdentalsurgery.repository.DentistRepository;
import edu.miu.cs.cs489.lab7.adsdentalsurgery.service.DentistService;
import org.springframework.stereotype.Service;

@Service
public class DentistServiceImpl implements DentistService {

    private final DentistRepository dentistRepository;

    public DentistServiceImpl(DentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }

    @Override
    public Dentist save(Dentist dentist) {
        return dentistRepository.save(dentist);
    }

}
