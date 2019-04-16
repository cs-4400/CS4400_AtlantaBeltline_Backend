package com.CS4400.AtlantaBeltLine.DTO;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "site")
public class Site {

    private String name;
    private String address;
    private int zipcode;
    private String open_everyday; //should this be enum type????
    private String username;

    public Site() {
    }

    public Site(String name, String address, int zipcode, String open_everyday, String username) {
        this.name = name;
        this.address = address;
        this.zipcode = zipcode;
        this.open_everyday = open_everyday;
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getOpen_everyday() {
        return open_everyday;
    }

    public void setOpen_everyday(String open_everyday) {
        this.open_everyday = open_everyday;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
