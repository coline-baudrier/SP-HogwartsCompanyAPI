package com.hogwartscompany.phonebook.controller.employee.model;

import java.sql.Timestamp;

public class NewEmployee {
    String firstName;
    String lastName;
    String jobEmployee;
    int serviceEmployee;
    String phoneEmployee;
    String cellphoneEmployee;
    String emailEmployee;
    Timestamp birthDate;
    Timestamp hiringDate;
    Boolean adminApplication;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJobEmployee() {
        return jobEmployee;
    }

    public void setJobEmployee(String jobEmployee) {
        this.jobEmployee = jobEmployee;
    }

    public int getServiceEmployee() {
        return serviceEmployee;
    }

    public void setServiceEmployee(int serviceEmployee) {
        this.serviceEmployee = serviceEmployee;
    }

    public String getPhoneEmployee() {
        return phoneEmployee;
    }

    public void setPhoneEmployee(String phoneEmployee) {
        this.phoneEmployee = phoneEmployee;
    }

    public String getCellphoneEmployee() {
        return cellphoneEmployee;
    }

    public void setCellphoneEmployee(String cellphoneEmployee) {
        this.cellphoneEmployee = cellphoneEmployee;
    }

    public String getEmailEmployee() {
        return emailEmployee;
    }

    public void setEmailEmployee(String emailEmployee) {
        this.emailEmployee = emailEmployee;
    }

    public Timestamp getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Timestamp birthDate) {
        this.birthDate = birthDate;
    }

    public Timestamp getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(Timestamp hiringDate) {
        this.hiringDate = hiringDate;
    }

    public Boolean getAdminApplication() {
        return adminApplication;
    }

    public void setAdminApplication(Boolean adminApplication) {
        this.adminApplication = adminApplication;
    }
}
