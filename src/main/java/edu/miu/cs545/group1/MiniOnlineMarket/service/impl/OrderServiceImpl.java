package edu.miu.cs545.group1.MiniOnlineMarket.service.impl;

import edu.miu.cs545.group1.MiniOnlineMarket.domain.Buyer;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.Order;
import edu.miu.cs545.group1.MiniOnlineMarket.repository.OrderRepo;
import edu.miu.cs545.group1.MiniOnlineMarket.repository.UserRepo;
import edu.miu.cs545.group1.MiniOnlineMarket.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepo orderRepo;

    @Autowired
    public OrderServiceImpl(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public Order findById(Long id) {
        return null;
    }

    @Override
    public Order createOrder() {
        return null;
    }

    @Override
    public void updateOrder(Long id, Order order) {

    }

    @Override
    public void deleteOrder(Long id) {

    }

    @Override
    public void shipOrder(Long id) {

    }

    @Override
    public void cancelOrder(Long id) {

    }

    @Override
    public List<Order> findBuyerOrderHistory(Buyer buyer) {
        return orderRepo.findAllByBuyerOrderByDateCreatedDesc(buyer);
    }
}
