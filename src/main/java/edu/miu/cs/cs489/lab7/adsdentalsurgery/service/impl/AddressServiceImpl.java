package edu.miu.cs.cs489.lab7.adsdentalsurgery.service.impl;

import edu.miu.cs.cs489.lab7.adsdentalsurgery.model.Address;
import edu.miu.cs.cs489.lab7.adsdentalsurgery.repository.AddressRepository;
import edu.miu.cs.cs489.lab7.adsdentalsurgery.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> getAllSortedByCity() {
        return addressRepository.findAllByOrderByCityAsc();
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address); // ✅ Now defined
    }
}
