package edu.miu.cs.cs489.lab7.adsdentalsurgery.controller;

import edu.miu.cs.cs489.lab7.adsdentalsurgery.model.Address;
import edu.miu.cs.cs489.lab7.adsdentalsurgery.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adsweb/api/v1/addresses")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public ResponseEntity<List<Address>> getAllAddressesSortedByCity() {
        List<Address> addresses = addressService.getAllSortedByCity();
        return ResponseEntity.ok(addresses);
    }
}
