package com.security.model;

/**
 * Created by Abdullah Al Amin on 5/23/2018.
 */
public class JwtUser {
    private String role;
    private long id;
    private String username;

    public void setRole(String role) {
        this.role = role;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
}
