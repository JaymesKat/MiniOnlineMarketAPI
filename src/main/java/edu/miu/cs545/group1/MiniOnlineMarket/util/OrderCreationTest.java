package edu.miu.cs545.group1.MiniOnlineMarket.util;

import edu.miu.cs545.group1.MiniOnlineMarket.domain.*;
import edu.miu.cs545.group1.MiniOnlineMarket.repository.BuyerRepo;
import edu.miu.cs545.group1.MiniOnlineMarket.repository.OrderRepo;
import edu.miu.cs545.group1.MiniOnlineMarket.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class OrderCreationTest implements CommandLineRunner {

    private OrderRepo orderRepo;
    private BuyerRepo buyerRepo;
    private ProductRepo productRepo;

    @Autowired
    public OrderCreationTest(OrderRepo orderRepo,
                            BuyerRepo buyerRepo,
                            ProductRepo productRepo) {
        this.orderRepo = orderRepo;
        this.buyerRepo = buyerRepo;
        this.productRepo = productRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        Buyer buyer = buyerRepo.findAll().get(0);
        Product product = productRepo.findAll().get(0);
        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product);
        orderItem.setQuantity(3);

        Order order = new Order();
        order.setBuyer(buyer);
        order.setStatus(OrderStatus.PENDING);
        order.setDateCreated(LocalDateTime.now());
        order.addOrderItem(orderItem);
        orderRepo.save(order);
    }
}
