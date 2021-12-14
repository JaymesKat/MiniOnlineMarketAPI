package edu.miu.cs545.group1.MiniOnlineMarket.service.impl;

import edu.miu.cs545.group1.MiniOnlineMarket.domain.Product;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.ProductReview;
import edu.miu.cs545.group1.MiniOnlineMarket.repository.ProductRepo;
import edu.miu.cs545.group1.MiniOnlineMarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepo productRepo;

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepo.findById(id).get();
    }

    @Override
    public void updateProduct(Long id, Product product) {
        if(productRepo.findById(id).isPresent())
            productRepo.save(product);

    }
    // we should check if the product is in one purchase
    // if yes we should not delete it
    @Override
    public void deleteProduct(Long id) {
        if(productRepo.findById(id).isPresent())
            productRepo.delete(productRepo.findById(id).get());
    }

    @Override
    public Double calcAvgRating(Long id) {
        Product temp = productRepo.findById(id).get();
        Double rating = 0.0;
        if(temp != null){
            for(ProductReview pr: temp.getReviews() ){
                rating += pr.getRating();
            }
            return rating/temp.getReviews().size();
        }
        return rating;
    }
}
