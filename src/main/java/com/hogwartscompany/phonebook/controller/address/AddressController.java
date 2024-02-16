package com.hogwartscompany.phonebook.controller.address;

import com.hogwartscompany.phonebook.business.address.AddressBusiness;
import com.hogwartscompany.phonebook.controller.address.model.Address;
import com.hogwartscompany.phonebook.controller.address.model.NewAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Validated
public class AddressController {
    private final String version = "/api/v1";
    private final AddressBusiness addressBusiness;

    @Autowired
    public AddressController(AddressBusiness addressBusiness) {
        this.addressBusiness = addressBusiness;
    }

    //Liste des controllers (end points)
    @PostMapping(version + "/addresses")
    public Address createAddress(@RequestBody NewAddress address) {
        return addressBusiness.createAddressService(address);
    }
    @DeleteMapping(version + "/addresses/{id}")
    public boolean deleteAddress(@PathVariable int id){
        return addressBusiness.deleteAddressService(id);
    }
    @PutMapping(version + "/addresses/{id}")
    public Address updateAddress(@PathVariable int id, @RequestBody NewAddress address) {
        return addressBusiness.updateAddressService(id, address);
    }
    @GetMapping(version + "/addresses/{id}")
    public Address getOneAddress(@PathVariable int id) {
        return addressBusiness.getOneAddressService(id);
    }
    @GetMapping(version + "/addresses")
    public List<Address> getAllAddresses(
            @RequestParam(value = "buildingName", required = false) String nameBuilding,
            @RequestParam(value = "departmentCode", required = false) String departmentCode,
            @RequestParam(value = "cityName", required = false) String cityName)
            {
        return addressBusiness.getAllAddressService(nameBuilding,departmentCode,cityName);
    }
}
