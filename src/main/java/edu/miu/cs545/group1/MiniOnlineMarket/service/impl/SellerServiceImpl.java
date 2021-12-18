package edu.miu.cs545.group1.MiniOnlineMarket.service.impl;

import edu.miu.cs545.group1.MiniOnlineMarket.domain.*;
import edu.miu.cs545.group1.MiniOnlineMarket.repository.SellerRepo;
import edu.miu.cs545.group1.MiniOnlineMarket.service.ProductService;
import edu.miu.cs545.group1.MiniOnlineMarket.service.SaleService;
import edu.miu.cs545.group1.MiniOnlineMarket.service.SellerService;
import edu.miu.cs545.group1.MiniOnlineMarket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    SellerRepo sellerRepo;

    @Autowired
    SaleService saleService;

    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;

    @Override
    public List<Buyer> getFollowers(Long sellerId) {
        return sellerRepo.findById(sellerId).get().getFollowers();
    }

    @Override
    public Seller findByUser(User user) {
        return sellerRepo.findByUser(user.getId());
    }

    @Override
    public void changeSaleStatus(Long saleId, OrderStatus saleStatus) {
        Sale currentSale = saleService.getSale(saleId);
        Product productInSale = currentSale.getProduct();
        saleService.updateSale(currentSale);
        currentSale.setSaleStatus(saleStatus);

        if(saleStatus == OrderStatus.CANCELLED && currentSale.getSaleStatus() == OrderStatus.PENDING){
            productService.increaseQuantity(productInSale.getId(), currentSale.getQuantity());
        }

    }

    @Override
    public List<Seller> getAllSellers() {
        return sellerRepo.findAll();
    }

    @Override
    public Seller getSeller(Long sellerId) {
        return sellerRepo.findById(sellerId).get();
    }

    @Override
    public void addSeller(Seller seller) {
        sellerRepo.save(seller);
    }

    @Override
    public List<Product> getProducts(Long sellerId) {
        return getSeller(sellerId).getProducts();
    }

    public Seller getLoggedInSeller(Authentication auth) {
        User user = userService.getLoggedInUser(auth);
        Seller seller = findByUser(user);
        return seller;
    }

    @Override
    public void addProduct(Seller seller, Product product) {
        product.setSeller(seller);
        productService.addProduct(product);
    }

    @Override
    public Product findProductById(Seller seller, long productId) {
        return productService.getProductForSeller(seller, productId);
    }
}
