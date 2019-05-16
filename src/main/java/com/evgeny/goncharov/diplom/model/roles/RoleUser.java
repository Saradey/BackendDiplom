package com.evgeny.goncharov.diplom.model.roles;

import org.springframework.security.core.GrantedAuthority;

public class RoleUser implements GrantedAuthority {

    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public RoleUser(String role) {
        this.role = role;
    }

    public RoleUser() {
    }



    @Override
    public String getAuthority() {
        return null;
    }


}
