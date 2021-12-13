package edu.miu.cs545.group1.MiniOnlineMarket.service;

import edu.miu.cs545.group1.MiniOnlineMarket.domain.Buyer;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.OrderStatus;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.Product;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.Seller;

import java.util.List;

public interface SellerService {
    List<Buyer> getFollowers(Long sellerId);
    void changeSaleStatus(Long orderId, OrderStatus saleStatus);
    List<Seller> getAllSellers();
    Seller getSeller(Long sellerId);
    void addSeller(Seller seller);
    List<Product> getProducts(Long sellerId);

}
