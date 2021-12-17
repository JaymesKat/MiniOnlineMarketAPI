package edu.miu.cs545.group1.MiniOnlineMarket.service;

import edu.miu.cs545.group1.MiniOnlineMarket.domain.Product;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.Seller;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(Long id);
    void updateProduct(Long id, Product product);
    void deleteProduct(Long id);
    void addProduct(Product product);
    Double calcAvgRating(Long id);
    void decreaseQuantity(Long productId, Integer quantity);
    void increaseQuantity(Long productId, Integer quantity);

    Product getProductForSeller(Seller seller, long productId);
}
