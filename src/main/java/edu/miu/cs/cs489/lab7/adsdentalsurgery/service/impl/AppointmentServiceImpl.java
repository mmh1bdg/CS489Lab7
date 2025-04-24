package edu.miu.cs.cs489.lab7.adsdentalsurgery.service.impl;

import edu.miu.cs.cs489.lab7.adsdentalsurgery.model.Appointment;
import edu.miu.cs.cs489.lab7.adsdentalsurgery.repository.AppointmentRepository;
import edu.miu.cs.cs489.lab7.adsdentalsurgery.service.AppointmentService;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Appointment save(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

}
