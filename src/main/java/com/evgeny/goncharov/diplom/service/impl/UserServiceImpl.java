package com.evgeny.goncharov.diplom.service.impl;

import com.evgeny.goncharov.diplom.common.consts.ApiAnswer;
import com.evgeny.goncharov.diplom.common.exeptions.UserWasException;
import com.evgeny.goncharov.diplom.model.model.Users;
import com.evgeny.goncharov.diplom.model.request.RequestRegUser;
import com.evgeny.goncharov.diplom.repository.UserRepository;
import com.evgeny.goncharov.diplom.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Autowired
    PasswordEncoder encoder;


    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return repository.findById(name).orElseThrow(() -> {
            return new UsernameNotFoundException(ApiAnswer.ERROR_USERNAME);
        });
    }


    @Override
    public void regUser(RequestRegUser user) throws UserWasException {
        if (repository.findById(user.getName()).isPresent()) {
            throw new UserWasException();

        } else {
            Users users = new Users();
            users.setUsername(user.getName());
            users.setPassword(encoder.encode(user.getPassword()));
            users.setEmail(user.getEmail());
            users.setEnabled(true);
            users.setAccountNonExpired(true);
            users.setAccountNonLocked(true);
            users.setCredentialsNonExpired(true);
            repository.saveAndFlush(users);
        }
    }


}
