package com.hogwartscompany.phonebook.utils.mapper;

import com.hogwartscompany.phonebook.dao.address.model.AddressDTO;
import com.hogwartscompany.phonebook.controller.address.model.Address;
import com.hogwartscompany.phonebook.controller.address.model.NewAddress;

public class MapperAddressWithAddressDTO {

    public AddressDTO AddressToDTO(Address address) {
        AddressDTO dto = new AddressDTO();
        dto.setIdAddress(address.getIdAddress());
        dto.setBuildingFloor(address.getBuildingFloor());
        dto.setBuildingName(address.getBuildingName());
        dto.setLineAddress1(address.getLineAddress1());
        dto.setLineAddress2(address.getLineAddress2());
        dto.setDepartmentCode(address.getDepartmentCode());
        dto.setCityName(address.getCityName());

        return dto;
    }

    public AddressDTO NewAddressToDTO(NewAddress address) {
        AddressDTO dto = new AddressDTO();
        dto.setBuildingFloor(address.getBuildingFloor());
        dto.setBuildingName(address.getBuildingName());
        dto.setLineAddress1(address.getLineAddress1());
        dto.setLineAddress2(address.getLineAddress2());
        dto.setDepartmentCode(address.getDepartmentCode());
        dto.setCityName(address.getCityName());

        return dto;
    }

    public Address DTOToAddress (AddressDTO dto) {
        Address address = new Address();
        address.setIdAddress(dto.getIdAddress());
        address.setBuildingFloor(dto.getBuildingFloor());
        address.setBuildingName(dto.getBuildingName());
        address.setLineAddress1(dto.getLineAddress1());
        address.setLineAddress2(dto.getLineAddress2());
        address.setDepartmentCode(dto.getDepartmentCode());
        address.setCityName(dto.getCityName());

        return address;
    }
}
