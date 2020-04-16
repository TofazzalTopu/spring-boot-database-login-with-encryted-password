package com.info.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "adm_user")
public class AdmUser {

    @Id
    private long id;
    private String userId;
    private String username;
    private String password;
    private boolean enabled;


    public long getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
