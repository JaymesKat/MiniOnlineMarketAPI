package edu.miu.cs545.group1.MiniOnlineMarket.service.impl;

import edu.miu.cs545.group1.MiniOnlineMarket.domain.Product;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.ProductReview;
import edu.miu.cs545.group1.MiniOnlineMarket.repository.ProductRepo;
import edu.miu.cs545.group1.MiniOnlineMarket.repository.SaleRepo;
import edu.miu.cs545.group1.MiniOnlineMarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    SaleRepo saleRepo;

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
//    @Override
//    public void deleteProduct(Long id) {
//        if(productRepo.findById(id).isPresent())
//        Product temp = productRepo.findById(id).orElse(null);
//        if(temp != null ){
//            temp.setTitle(product.getTitle());
//            temp.setDescription(product.getDescription());
//            temp.setCode(product.getCode());
//            temp.setPrice(product.getPrice());
//            temp.setQuantity(product.getQuantity());
//            temp.setDateCreated(product.getDateCreated());
//            //temp.setSeller(product.getSeller());
//
//
//            productRepo.save(temp);
//        }
//
//
//    }

    @Override
    public void deleteProduct(Long id) {
        Product tempProduct = productRepo.findById(id).get();
        Integer count = saleRepo.countAllByProduct(tempProduct);

        if(productRepo.findById(id).isPresent() && count == 0)
            productRepo.delete(productRepo.findById(id).get());
    }

    @Override
    public void addProduct(Product product) {
        productRepo.save(product);
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

    @Override
    public void increaseQuantity(Long productId, Integer quantity) {
        Product productToUpdate = productRepo.findById(productId).get();
        Integer currentQuantity = productToUpdate.getQuantity();
        productToUpdate.setQuantity(currentQuantity + quantity);
        updateProduct(productToUpdate.getId(), productToUpdate);
    }
    @Override
    public void decreaseQuantity(Long productId, Integer quantity) {
        Product productToUpdate = productRepo.findById(productId).get();
        Integer currentQuantity = productToUpdate.getQuantity();
        productToUpdate.setQuantity(currentQuantity - quantity);
        updateProduct(productToUpdate.getId(), productToUpdate);
    }
}
