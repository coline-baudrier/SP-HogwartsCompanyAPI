package com.hogwartscompany.phonebook.dao.address.model;

public class AddressDTO {

    int idAddress;
    String buildingFloor;
    String buildingName;
    String lineAddress1;
    String lineAddress2;
    String departmentCode;
    String cityName;

    //Getters and Setters
    public int getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
    }

    public String getBuildingFloor() {
        return buildingFloor;
    }

    public void setBuildingFloor(String buildingFloor) {
        this.buildingFloor = buildingFloor;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getLineAddress1() {
        return lineAddress1;
    }

    public void setLineAddress1(String lineAddress1) {
        this.lineAddress1 = lineAddress1;
    }

    public String getLineAddress2() {
        return lineAddress2;
    }

    public void setLineAddress2(String lineAddress2) {
        this.lineAddress2 = lineAddress2;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
