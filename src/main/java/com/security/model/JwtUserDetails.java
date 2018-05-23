package com.security.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * Created by Abdullah Al Amin on 5/23/2018.
 */
public class JwtUserDetails implements UserDetails {
    private String userName;
    private long id;
    private String token;
    private Collection<? extends GrantedAuthority> authorities;


    public JwtUserDetails(String username, long id, String token, List<GrantedAuthority> roles) {
        this.userName = username;
        this.id = id;
        this.authorities = roles;
        this.token = token;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getUserName() {
        return userName;
    }


    public long getId() {
        return id;
    }


    public String getToken() {
        return token;
    }

}
