package edu.miu.cs545.group1.MiniOnlineMarket.service.impl;

import edu.miu.cs545.group1.MiniOnlineMarket.domain.*;
import edu.miu.cs545.group1.MiniOnlineMarket.repository.OrderItemRepo;
import edu.miu.cs545.group1.MiniOnlineMarket.repository.OrderRepo;
import edu.miu.cs545.group1.MiniOnlineMarket.service.CartService;
import edu.miu.cs545.group1.MiniOnlineMarket.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderRepo orderRepository;

    @Autowired
    private OrderItemRepo orderItemsRepository;

    @Override
    public List<Order> findBuyerOrderHistory(Buyer buyer) {
        return null;
    }

    @Override
    public Order placeOrder(Buyer user) {
        Cart cart = cartService.findByOwner(user);
        List<CartItem> cartItemList = cart.getItems(); // first let get cart items for the user

        // create the order and save it
        Order newOrder = new Order();
        newOrder.setDateCreated(LocalDateTime.now());
        newOrder.setBuyer(user);
        newOrder.setStatus(OrderStatus.PENDING);
        orderRepository.save(newOrder);

        for (CartItem cartItem : cartItemList) {
            // create orderItem and save each one
            OrderItem orderItem = new OrderItem();
//                orderItem.setStatus(OrderStatus.PENDING);
            orderItem.setProduct(cartItem.getProduct());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setOrder(newOrder);
            // add to order item list
            orderItemsRepository.save(orderItem);
        }
        //
        cartService.deleteCart(user);
        return newOrder;
    }

    @Override
    public List<Order> listOrders(Buyer user) {
        return orderRepository.findAllByBuyerOrderByDateCreatedDesc(user);
    }

    @Override
    public Order getOrder(Long orderId) throws IllegalArgumentException {
        Optional<Order> order = orderRepository.findById(orderId);
        if (order.isPresent()) {
            return order.get();
        }
        throw new IllegalArgumentException("Order not found");
    }

    @Override
    public boolean cancelOrder(Long orderId) {
        Order order = this.getOrder(orderId);
        if (order.getStatus() != OrderStatus.SHIPPED) {
            order.setStatus(OrderStatus.CANCELLED);
            orderRepository.save(order);
            return true;
        }
        return false;
    }
}

