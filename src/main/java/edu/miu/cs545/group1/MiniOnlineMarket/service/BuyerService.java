package edu.miu.cs545.group1.MiniOnlineMarket.service;

import edu.miu.cs545.group1.MiniOnlineMarket.domain.*;

import java.util.List;

public interface BuyerService {
    Buyer findById(Long id);
    void followSeller(Long buyerId, Long sellerId);
    void unFollowSeller(Long buyerId, Long sellerId);
    List<Seller> getFollowees(Long buyerId);
    void registerBuyer(Buyer buyer);
    Order createOrder(Cart cart);
}
