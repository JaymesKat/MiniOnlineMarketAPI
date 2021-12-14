package edu.miu.cs545.group1.MiniOnlineMarket.controller;

import edu.miu.cs545.group1.MiniOnlineMarket.domain.*;
import edu.miu.cs545.group1.MiniOnlineMarket.dto.SalesDTO;
import edu.miu.cs545.group1.MiniOnlineMarket.service.ProductService;
import edu.miu.cs545.group1.MiniOnlineMarket.service.SaleService;
import edu.miu.cs545.group1.MiniOnlineMarket.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/{id}")
    public Seller getSeller(@PathVariable("id") Long sellerId){
       return sellerService.getSeller(sellerId);
    }
    @PostMapping
    public void addSeller(@RequestBody Seller seller){
        sellerService.addSeller(seller);
    }
    @GetMapping("/{id}/sales")
    public List<Sale> getAllSalesForSeller(@PathVariable("id") Long sellerId){
        return saleService.getAllSales();
    }
    @GetMapping("/{id}/followers")
    public List<Buyer> getFollowers(@PathVariable("id") Long sellerId){
        return sellerService.getFollowers(sellerId);
    }
    @PatchMapping ("/{sellerId}/sales/{saleId}")
    public void changeSaleStatus(@RequestBody SalesDTO status,
                                 @PathVariable("saleId") Long saleId){
        sellerService.changeSaleStatus(saleId,OrderStatus.valueOf(status.getOrderStatus()));
    }
    @GetMapping("/{sellerId}/products")
    public List<Product> getAllSellerProducts(@PathVariable("sellerId") Long sellerId){
        return sellerService.getProducts(sellerId);
    }

    @PutMapping("/{sellerId}/products/{productId}")
    public void updateProduct(@RequestBody Product product,
    @PathVariable("productId") Long productId){
        productService.updateProduct(productId, product);
    }

    @DeleteMapping("/{sellerId}/products/{productId}")
    public void deleteProduct(@PathVariable("productId") Long productId){
        productService.deleteProduct(productId);
    }
    @PostMapping("/{sellerId}/products")
    public void addProduct(@RequestBody Product product){
        productService.addProduct(product);
    }
}
