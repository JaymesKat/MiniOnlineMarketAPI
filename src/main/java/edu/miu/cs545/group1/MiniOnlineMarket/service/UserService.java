package edu.miu.cs545.group1.MiniOnlineMarket.service;

import edu.miu.cs545.group1.MiniOnlineMarket.domain.User;
import org.springframework.security.core.Authentication;

public interface UserService {
    User getLoggedInUser(Authentication authentication);
}
