package edu.miu.cs545.group1.MiniOnlineMarket.controller;

import edu.miu.cs545.group1.MiniOnlineMarket.domain.*;
import edu.miu.cs545.group1.MiniOnlineMarket.dto.SalesDTO;
import edu.miu.cs545.group1.MiniOnlineMarket.service.ProductService;
import edu.miu.cs545.group1.MiniOnlineMarket.service.SaleService;
import edu.miu.cs545.group1.MiniOnlineMarket.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/sellers")

public class SellerController {
    @Autowired
    SellerService sellerService;

    @Autowired
    SaleService saleService;

    @Autowired
    ProductService productService;

    @GetMapping
    public List<Seller> getAllSeller(){
        return sellerService.getAllSellers();
    }

    @GetMapping("/details")
    public Seller getSeller(Authentication auth){
        Seller seller = sellerService.getLoggedInSeller(auth);
        return sellerService.getSeller(seller.getId());
    }
    @PostMapping
    public void addSeller(@RequestBody Seller seller){
        sellerService.addSeller(seller);
    }

    @GetMapping("/sales")
    public List<Sale> getAllSalesForSeller(Authentication auth){
        Seller seller = sellerService.getLoggedInSeller(auth);
        return saleService.getSellerSales(seller.getId());
    }
    @GetMapping("/followers")
    public List<Buyer> getFollowers(Authentication auth){
        Seller seller = sellerService.getLoggedInSeller(auth);
        return sellerService.getFollowers(seller.getId());
    }
    @PatchMapping ("/sales/{saleId}")
    public void changeSaleStatus(@RequestBody SalesDTO status,
                                 @PathVariable("saleId") Long saleId){
        sellerService.changeSaleStatus(saleId,OrderStatus.valueOf(status.getOrderStatus()));
    }
    @GetMapping("/products")
    public List<Product> getAllSellerProducts(Authentication auth){
        Seller seller = sellerService.getLoggedInSeller(auth);
        return sellerService.getProducts(seller.getId());
    }

    @PutMapping("/products/{productId}")
    public void updateProduct(@RequestBody Product product,
    @PathVariable("productId") Long productId){
        productService.updateProduct(productId, product);
    }

    @DeleteMapping("/products/{productId}")
    public void deleteProduct(@PathVariable("productId") Long productId){
        productService.deleteProduct(productId);
    }

    @PostMapping("/{sellerId}/products")
    public void addProduct(@RequestBody Product product){
        productService.addProduct(product);
    }
}
