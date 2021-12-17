package edu.miu.cs545.group1.MiniOnlineMarket.service;

import edu.miu.cs545.group1.MiniOnlineMarket.domain.*;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface SellerService {
    List<Buyer> getFollowers(Long sellerId);
    void changeSaleStatus(Long orderId, OrderStatus saleStatus);
    List<Seller> getAllSellers();
    Seller getSeller(Long sellerId);
    void addSeller(Seller seller);
    List<Product> getProducts(Long sellerId);
    Seller findByUser(User user);
    Seller getLoggedInSeller(Authentication auth);
}
