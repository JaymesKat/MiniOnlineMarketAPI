package edu.miu.cs545.group1.MiniOnlineMarket.controller;

import edu.miu.cs545.group1.MiniOnlineMarket.domain.Address;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.Buyer;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.Order;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.Seller;
import edu.miu.cs545.group1.MiniOnlineMarket.dto.AddressDTO;
import edu.miu.cs545.group1.MiniOnlineMarket.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/v1/buyers")
public class BuyerController {

    public BuyerService buyerService;

    @Autowired
    public BuyerController(BuyerService buyerService) {
        this.buyerService = buyerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Buyer> getBuyer(@PathVariable("id") Long buyerId){
        return new ResponseEntity(buyerService.findById(buyerId), HttpStatus.OK);
    }

    @GetMapping("/{id}/orders")
    public ResponseEntity<List<Order>> getOrderHistory(@PathVariable("id") Long id){
        List<Order> buyerOrders = buyerService.getBuyerOrders(id);
        return new ResponseEntity<>(buyerOrders, HttpStatus.OK);
    }

    @GetMapping("/{id}/followees/")
    public ResponseEntity<List<Seller>> getFollowers(@PathVariable("id") Long buyerId) {
        return new ResponseEntity(buyerService.getFollowees(buyerId), HttpStatus.OK);
    }


    @PatchMapping("/{buyerId}/sellers/{sellerId}/follow")
    public void followSeller(@PathVariable("buyerId") Long buyerId,
                                     @PathVariable("sellerId") Long sellerId) {
        buyerService.followSeller(buyerId, sellerId);
    }

    @PatchMapping("/{buyerId}/sellers/{sellerId}/unfollow")
    public void unFollowSeller(@PathVariable("buyerId") Long buyerId,
                             @PathVariable("sellerId") Long sellerId) {
        buyerService.unFollowSeller(buyerId, sellerId);
    }

    //======================================Mapping for addresses...==========================================

    @PostMapping("/{id}/addresses")
    public void linkAddressesToBuyer(@PathVariable("id") Long buyerId, @RequestBody AddressDTO addresses){
        buyerService.linkAddressesToBuyer(buyerId, addresses);
    }

    @GetMapping("/{id}/addresses")
    public AddressDTO getAddresses(@PathVariable("id") Long buyerId){
        Buyer buyer = buyerService.findById(buyerId);
        AddressDTO addresses = new AddressDTO();
        addresses.setBillingAddress(buyer.getBillingAddress());
        addresses.setShippingAddress(buyer.getShippingAddress());
        return addresses;
    }

    @PutMapping("/{id}/addresses/shipping")
    public void updateShippingAddress(@PathVariable("id") Long buyerId, @RequestBody Address address){
        buyerService.updateShippingAddress(buyerId, address);
    }

    @PutMapping("/{id}/addresses/billing")
    public void updateBillingingAddress(@PathVariable("id") Long buyerId, @RequestBody Address address){
        buyerService.updateBillingAddress(buyerId, address);
    }
}
