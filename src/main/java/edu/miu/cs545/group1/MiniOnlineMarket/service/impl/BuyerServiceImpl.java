package edu.miu.cs545.group1.MiniOnlineMarket.service.impl;

import edu.miu.cs545.group1.MiniOnlineMarket.constants.ErrorMessages;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.Buyer;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.Cart;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.Order;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.Seller;
import edu.miu.cs545.group1.MiniOnlineMarket.repository.BuyerRepo;
import edu.miu.cs545.group1.MiniOnlineMarket.repository.SellerRepo;
import edu.miu.cs545.group1.MiniOnlineMarket.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BuyerServiceImpl implements BuyerService {

    private BuyerRepo buyerRepo;
    private SellerRepo sellerRepo;

    @Autowired
    public BuyerServiceImpl(BuyerRepo buyerRepo, SellerRepo sellerRepo) {
        this.buyerRepo = buyerRepo;
        this.sellerRepo = sellerRepo;
    }


    @Override
    public Buyer findById(Long id) {
        return buyerRepo.findById(id)
                .orElseThrow(()-> new NoSuchElementException(ErrorMessages.BUYER_NOT_FOUND));
    }

    @Override
    public void followSeller(Long buyerId, Long sellerId) {
        Buyer buyer = findById(buyerId);
        Seller seller = sellerRepo.findById(sellerId)
                .orElseThrow(()-> new NoSuchElementException(ErrorMessages.SELLER_NOT_FOUND));
        if(!buyer.getFollowees().contains(seller)){
            buyer.addFollowee(seller);
            buyerRepo.save(buyer);
        }
    }

    @Override
    public void unFollowSeller(Long buyerId, Long sellerId) {
        Buyer buyer = findById(buyerId);
        Seller seller = sellerRepo.findById(sellerId)
                .orElseThrow(()-> new NoSuchElementException(ErrorMessages.SELLER_NOT_FOUND));

        if(buyer.getFollowees().contains(seller)) {
            buyer.removeFollowee(seller);
            buyerRepo.save(buyer);
        }
    }

    @Override
    public List<Seller> getFollowees(Long buyerId) {
         Buyer buyer = findById(buyerId);
         return buyer.getFollowees();
    }

    @Override
    public void registerBuyer(Buyer buyer) {
        buyerRepo.save(buyer);
    }

    @Override
    public Order createOrder(Cart cart) {
        return null;
    }
}
