package com.evgeny.goncharov.diplom.service.interfaces;

import com.evgeny.goncharov.diplom.common.exeptions.UserWasException;
import com.evgeny.goncharov.diplom.model.request.RequestRegUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    void regUser(RequestRegUser user) throws UserWasException;

}
