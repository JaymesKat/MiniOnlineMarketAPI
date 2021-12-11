package edu.miu.cs545.group1.MiniOnlineMarket.service;

import edu.miu.cs545.group1.MiniOnlineMarket.domain.Product;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.ProductReview;

import java.util.List;

public interface ProductReviewService {
    public List<ProductReview> findAll();
    public ProductReview findById(Long id);
    public void updateProductReview(Long id, ProductReview productReview);
    public void deleteProductReview(Long id);
    public void approveReview(Long id);
}
