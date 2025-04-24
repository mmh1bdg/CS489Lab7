package edu.miu.cs.cs489.lab7.adsdentalsurgery.service;

import edu.miu.cs.cs489.lab7.adsdentalsurgery.model.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAllSortedByCity();
    Address save(Address address); // ✅ Add this
}
