package edu.miu.cs545.group1.MiniOnlineMarket.service;

import edu.miu.cs545.group1.MiniOnlineMarket.domain.Cart;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.CartItem;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.Order;

import java.util.List;

public interface CartService {
    Cart findByUserId(Long userId);
    Cart addItemToCart(CartItem cartItem);
    void removeItemFromCart(Long itemId);
}
