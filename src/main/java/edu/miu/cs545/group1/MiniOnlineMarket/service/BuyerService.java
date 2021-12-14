package edu.miu.cs545.group1.MiniOnlineMarket.service;

import edu.miu.cs545.group1.MiniOnlineMarket.domain.*;
import edu.miu.cs545.group1.MiniOnlineMarket.dto.AddressDTO;

import java.util.List;

public interface BuyerService {
    Buyer findById(Long id);
    Buyer findByEmail(String email);
    void followSeller(Long buyerId, Long sellerId);
    void unFollowSeller(Long buyerId, Long sellerId);
    List<Seller> getFollowees(Long buyerId);
    void registerBuyer(Buyer buyer);
    Order createOrder(Cart cart);
    void linkAddressesToBuyer(Long buyerId, AddressDTO addresses);
    void updateShippingAddress(Long buyerId, Address address);
    void updateBillingAddress(Long buyerId, Address address);
    List<Order> getBuyerOrders(Long id);
}
