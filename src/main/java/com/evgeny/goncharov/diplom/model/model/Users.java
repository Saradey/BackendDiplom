package com.evgeny.goncharov.diplom.model.model;

import com.evgeny.goncharov.diplom.model.request.RequestRegUser;
import com.evgeny.goncharov.diplom.model.roles.RoleUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Collection;
import java.util.List;


@Entity
public class Users implements UserDetails {

    @Id
    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean enabled;

//    @Column(nullable=false)
//    private List<RoleUser> authorities;

    @Column(nullable = false)
    private boolean accountNonExpired;

    @Column(nullable = false)
    private boolean accountNonLocked;

    @Column(nullable = false)
    private boolean credentialsNonExpired;

    @Column(nullable = false)
    private String email;


    public Users() {
    }

    //Возвращает полномочия, предоставленные пользователю.
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    //Указывает, истек ли срок действия учетной записи пользователя.
    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    //Указывает, заблокирован ли пользователь или разблокирован.
    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    //Указывает, истек ли срок действия учетных данных пользователя (пароля).
    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    //Указывает, включен ли пользователь или отключен.
    @Override
    public boolean isEnabled() {
        return enabled;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public void setAuthorities(List<RoleUser> authorities) {
//        this.authorities = authorities;
//    }
}



