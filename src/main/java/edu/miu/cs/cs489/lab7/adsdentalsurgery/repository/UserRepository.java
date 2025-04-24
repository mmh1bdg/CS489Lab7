package edu.miu.cs.cs489.lab7.adsdentalsurgery.repository;

import edu.miu.cs.cs489.lab7.adsdentalsurgery.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
