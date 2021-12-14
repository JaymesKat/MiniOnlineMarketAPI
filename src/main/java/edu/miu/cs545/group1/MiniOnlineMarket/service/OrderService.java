package edu.miu.cs545.group1.MiniOnlineMarket.service;

import edu.miu.cs545.group1.MiniOnlineMarket.domain.Buyer;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.Order;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.Order;

import java.util.List;

public interface OrderService {
//    public List<Order> findAll();
//    Order findById(Long id);
//    Order createOrder();
//    void updateOrder(Long id, Order order);
//    void deleteOrder(Long id);
//    void shipOrder(Long id);
    boolean cancelOrder(Long orderId);
    List<Order> findBuyerOrderHistory(Buyer buyer);
    Order placeOrder(Buyer user);
    List<Order> listOrders(Buyer user);
    Order getOrder(Long orderId);
//    void deleteOrder(Long orderId);
}
