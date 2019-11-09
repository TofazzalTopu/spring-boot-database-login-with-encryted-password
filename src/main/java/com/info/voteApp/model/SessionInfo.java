package com.info.voteApp.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "session_info")
public class SessionInfo {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "session_code")
    private String sessionCode;

    @Column(name = "description",length = 1000)
    @Size(max = 1000)
    private String description;

    private boolean isActive;

    public SessionInfo() {
    }

    public SessionInfo(String sessionCode, String description) {
        this.sessionCode = sessionCode;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSessionCode() {
        return sessionCode;
    }

    public void setSessionCode(String sessionCode) {
        this.sessionCode = sessionCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
