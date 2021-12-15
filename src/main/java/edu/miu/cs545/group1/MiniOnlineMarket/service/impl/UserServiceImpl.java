package edu.miu.cs545.group1.MiniOnlineMarket.service.impl;

import edu.miu.cs545.group1.MiniOnlineMarket.auth.MyUserDetails;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.User;
import edu.miu.cs545.group1.MiniOnlineMarket.service.AddressService;
import edu.miu.cs545.group1.MiniOnlineMarket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    public User getLoggedInUser(Authentication auth) {
        String username = (String) auth.getPrincipal();
        MyUserDetails userDetails = (MyUserDetails)userDetailsService.loadUserByUsername(username);
        User user = userDetails.getUser();
        return user;
    }
}
