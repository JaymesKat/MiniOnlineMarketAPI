package edu.miu.cs545.group1.MiniOnlineMarket.service;

import edu.miu.cs545.group1.MiniOnlineMarket.domain.Product;

import java.util.List;

public interface ProductService {
    public List<Product> findAll();
    Product findById(Long id);
    void updateProduct(Long id, Product product);
    void deleteProduct(Long id);
    Double calcAvgRating(Long id);
}
