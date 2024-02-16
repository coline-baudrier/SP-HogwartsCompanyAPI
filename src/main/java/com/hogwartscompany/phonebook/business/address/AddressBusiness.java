package com.hogwartscompany.phonebook.business.address;

import com.hogwartscompany.phonebook.dao.address.AddressDAO;
import com.hogwartscompany.phonebook.controller.address.model.Address;
import com.hogwartscompany.phonebook.controller.address.model.NewAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressBusiness {
    private final AddressDAO addressDAO;

    @Autowired
    public AddressBusiness(AddressDAO addressDAO) {
        this.addressDAO = addressDAO;
    }
    public Address createAddressService(NewAddress address) {
        return addressDAO.create(address);
    }
    public boolean deleteAddressService(int id) {
        return addressDAO.delete(id);
    }
    public Address updateAddressService(int id, NewAddress address){
        return addressDAO.update(id, address);
    }
    public Address getOneAddressService(int id) {
        return addressDAO.getOne(id);
    }
    public List<Address> getAllAddressService(String buildingName, String departmentCode, String cityName){
        return addressDAO.getAll(buildingName, departmentCode, cityName);
    }
}
