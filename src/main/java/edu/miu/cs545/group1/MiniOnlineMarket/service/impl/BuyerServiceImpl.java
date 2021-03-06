package edu.miu.cs545.group1.MiniOnlineMarket.service.impl;

import edu.miu.cs545.group1.MiniOnlineMarket.constants.ErrorMessages;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.*;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.*;
import edu.miu.cs545.group1.MiniOnlineMarket.dto.AddressDTO;
import edu.miu.cs545.group1.MiniOnlineMarket.repository.AddressRepo;
import edu.miu.cs545.group1.MiniOnlineMarket.repository.BuyerRepo;
import edu.miu.cs545.group1.MiniOnlineMarket.repository.OrderRepo;
import edu.miu.cs545.group1.MiniOnlineMarket.repository.SellerRepo;
import edu.miu.cs545.group1.MiniOnlineMarket.service.BuyerService;
import edu.miu.cs545.group1.MiniOnlineMarket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BuyerServiceImpl implements BuyerService {

    private BuyerRepo buyerRepo;
    private SellerRepo sellerRepo;
    private UserService userService;
    @Autowired
    private AddressRepo addressRepo;
    private OrderRepo orderRepo;

    @Autowired
    public BuyerServiceImpl(BuyerRepo buyerRepo,
                            SellerRepo sellerRepo,UserService userService) {
        this.buyerRepo = buyerRepo;
        this.sellerRepo = sellerRepo;
        this.orderRepo = orderRepo;
        this.userService = userService;
    }


    @Override
    public Buyer findById(Long id) {
        return buyerRepo.findById(id)
                .orElseThrow(()-> new NoSuchElementException(ErrorMessages.BUYER_NOT_FOUND));
    }

    @Override
    public Buyer findByEmail(String email) {
        return buyerRepo.findByEmail(email);
    }

    @Override
    public Buyer findByUser(User user) {
        return buyerRepo.findByUser(user.getId());
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

    public Buyer getLoggedInBuyer(Authentication auth) {
        User user = userService.getLoggedInUser(auth);
        Buyer buyer = findByUser(user);
        return buyer;
    }

    @Override
    public Buyer save(Buyer buyer) {
        return buyerRepo.save(buyer);
    }

    @Override
    public void registerBuyer(Buyer buyer) {
        buyerRepo.save(buyer);
    }

    @Override
    public List<Order> getBuyerOrders(Long id) {
        Buyer buyer = findById(id);
        List<Order> orders = orderRepo.findAllByBuyerOrderByDateCreatedDesc(buyer);
        return orders;
    }

    //==================================Address management==========================================

    @Override
    public void linkAddressesToBuyer(Long buyerId, AddressDTO addresses) {
        Buyer buyer = findById(buyerId);
        buyer.setBillingAddress(addresses.getBillingAddress());
        buyer.setShippingAddress(addresses.getShippingAddress());
        buyerRepo.save(buyer);
    }

    @Override
    public void updateShippingAddress(Long buyerId, Address address) {
        Buyer buyer = findById(buyerId);
        Address addressToUpdate = buyer.getShippingAddress();
        addressToUpdate.setCity(address.getCity());
        addressToUpdate.setState(address.getState());
        addressToUpdate.setStreet(address.getStreet());
        addressToUpdate.setZip(address.getZip());
        addressRepo.save(addressToUpdate);
    }

    @Override
    public void updateBillingAddress(Long buyerId, Address address) {
        Buyer buyer = findById(buyerId);
        Address addressToUpdate = buyer.getBillingAddress();;
        addressToUpdate.setCity(address.getCity());
        addressToUpdate.setState(address.getState());
        addressToUpdate.setStreet(address.getStreet());
        addressToUpdate.setZip(address.getZip());
        addressRepo.save(addressToUpdate);
    }
}
