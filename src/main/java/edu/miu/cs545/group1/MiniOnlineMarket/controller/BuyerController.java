package edu.miu.cs545.group1.MiniOnlineMarket.controller;

import edu.miu.cs545.group1.MiniOnlineMarket.domain.Buyer;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.Seller;
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

}
