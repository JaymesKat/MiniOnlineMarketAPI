package edu.miu.cs545.group1.MiniOnlineMarket.controller;

import edu.miu.cs545.group1.MiniOnlineMarket.auth.MyUserDetails;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.Buyer;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.Order;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.User;
import edu.miu.cs545.group1.MiniOnlineMarket.service.BuyerService;
import edu.miu.cs545.group1.MiniOnlineMarket.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private BuyerService buyerService;

    @PostMapping
    public Order placeOrder(Authentication auth) {
        Buyer buyer = buyerService.getLoggedInBuyer(auth);
        return orderService.placeOrder(buyer);
    }

    // get all orders
    @GetMapping("")
    public List<Order> getAllOrders(Authentication auth) {
        Buyer buyer = buyerService.getLoggedInBuyer(auth);
        return orderService.listOrders(buyer);
    }

    // get orderitems for an order
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable("id") Long orderId) {
        Order order = orderService.getOrder(orderId);
        return order;
    }

    @PutMapping("/{id}")
    public boolean cancelOrder(@PathVariable("id") Long orderId) {
        return orderService.cancelOrder(orderId);
    }
}