package edu.miu.cs.cs489.lab7.adsdentalsurgery.repository;

import edu.miu.cs.cs489.lab7.adsdentalsurgery.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findAllByOrderByCityAsc();
}
