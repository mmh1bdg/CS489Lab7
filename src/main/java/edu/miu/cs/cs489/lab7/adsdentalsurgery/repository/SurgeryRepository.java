package edu.miu.cs.cs489.lab7.adsdentalsurgery.repository;

import edu.miu.cs.cs489.lab7.adsdentalsurgery.model.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurgeryRepository extends JpaRepository<Surgery, Long> {
}
