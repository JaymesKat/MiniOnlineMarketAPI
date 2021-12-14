package edu.miu.cs545.group1.MiniOnlineMarket.service.impl;

import edu.miu.cs545.group1.MiniOnlineMarket.domain.OrderItem;
import edu.miu.cs545.group1.MiniOnlineMarket.repository.OrderItemRepo;
import edu.miu.cs545.group1.MiniOnlineMarket.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired private OrderItemRepo orderItemRepo;

    @Override
    public void addItem(OrderItem orderItem) {
        orderItemRepo.save(orderItem);
    }
}
