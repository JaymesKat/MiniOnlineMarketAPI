package edu.miu.cs545.group1.MiniOnlineMarket.service;

import edu.miu.cs545.group1.MiniOnlineMarket.domain.*;
import edu.miu.cs545.group1.MiniOnlineMarket.dto.AddressDTO;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface BuyerService {
    Buyer findById(Long id);
    Buyer findByEmail(String email);
    Buyer findByUser(User user);
    void followSeller(Long buyerId, Long sellerId);
    void unFollowSeller(Long buyerId, Long sellerId);
    List<Seller> getFollowees(Long buyerId);
    void registerBuyer(Buyer buyer);
    List<Order> getBuyerOrders(Long id);
    public Buyer getLoggedInBuyer(Authentication auth);
    Buyer save(Buyer buyer);
    void linkAddressesToBuyer(Long buyerId, AddressDTO addresses);
    void updateShippingAddress(Long buyerId, Address address);
    void updateBillingAddress(Long buyerId, Address address);
}
