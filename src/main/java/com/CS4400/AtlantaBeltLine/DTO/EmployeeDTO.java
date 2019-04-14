package com.CS4400.AtlantaBeltLine.DTO;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class EmployeeDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Username")
    private String username;
    @Column(name = "EmpID")
    private int empID;
    @Column(name = "Phone")
    private String phone;
    @Column(name = "Address")
    private String address;
    @Column(name = "City")
    private String city;
    private String State;
    private int zip;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

}
