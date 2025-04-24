package edu.miu.cs.cs489.lab7.adsdentalsurgery.repository;

import edu.miu.cs.cs489.lab7.adsdentalsurgery.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
