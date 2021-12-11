package edu.miu.cs545.group1.MiniOnlineMarket.service;

import edu.miu.cs545.group1.MiniOnlineMarket.domain.*;

import java.util.List;

public interface BuyerService {
    void followSeller(Seller seller);
    void unFollowSeller(Seller seller);
    List<Seller> getFollowees();
    void registerBuyer(Buyer buyer);
    Order createOrder(Cart cart);
}
