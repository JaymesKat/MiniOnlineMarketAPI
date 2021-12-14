package edu.miu.cs545.group1.MiniOnlineMarket.service;

import edu.miu.cs545.group1.MiniOnlineMarket.domain.Cart;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.CartItem;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.Product;

import java.util.List;


public interface CartItemService {
    CartItem saveCartItem(CartItem cart);
    CartItem findById(Long cartId);
    void deleteCartItem(Long itemId);
    CartItem updateCartItem(Cart cart, CartItem cartItem);
    List<CartItem> findAll();
    CartItem findByProduct(Product product);
    CartItem findByCart(Cart cart);
}
