package edu.miu.cs545.group1.MiniOnlineMarket.service;

import edu.miu.cs545.group1.MiniOnlineMarket.domain.Address;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.User;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface AddressService {
    public List<Address> findAll();
    Address findById(Long id);
    void updateAddress(Long id, Address address);
    void deleteAddress(Long id);

    interface UserService {
        User getLoggedInUser(Authentication authentication);
    }
}
