package com.CS4400.AtlantaBeltLine.DTO;

import javax.persistence.*;

@Entity
@Table(name = "administrator")
public class AdministratorDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Username")
    private String Username;

    public AdministratorDTO() {
    }

    public AdministratorDTO(String username) {
        this.Username = username;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

}
