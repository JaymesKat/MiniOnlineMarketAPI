package edu.miu.cs545.group1.MiniOnlineMarket.service;

import edu.miu.cs545.group1.MiniOnlineMarket.domain.Buyer;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.Seller;

import java.util.List;

public interface SellerService {
    List<Buyer> getFollowers();
    void cancelOrder(Long orderId);
}
