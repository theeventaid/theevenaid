package com.tgj.eventaid.services;

import com.tgj.eventaid.models.Users;
import com.tgj.eventaid.models.UserWithRoles;
import com.tgj.eventaid.Repositories.UserRepository;
import com.tgj.eventaid.Repositories.UserRepository;
import com.tgj.eventaid.models.UserWithRoles;
import com.tgj.eventaid.models.Users;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsLoader implements UserDetailsService {
    private UserRepository usersDao;

    public UserDetailsLoader(UserRepository usersDao) {
        this.usersDao = usersDao;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = usersDao.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No email: %s found", email));
        }
        UserWithRoles userWithRoles = new UserWithRoles(user);
        return userWithRoles;
    }
}