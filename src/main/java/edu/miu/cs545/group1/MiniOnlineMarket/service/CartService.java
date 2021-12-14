package edu.miu.cs545.group1.MiniOnlineMarket.service;

import edu.miu.cs545.group1.MiniOnlineMarket.domain.Buyer;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.Cart;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.Product;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.User;
import edu.miu.cs545.group1.MiniOnlineMarket.dto.AddToCartDto;
import edu.miu.cs545.group1.MiniOnlineMarket.dto.UpdateCartDto;
import org.springframework.security.core.Authentication;


public interface CartService {
    Cart findByOwner(Buyer buyer);
    Cart findById(Long cartId);
    Cart createCart(Buyer buyer);
    Cart getOrCreateCart(Buyer buyer);
    Cart addItemToCart(AddToCartDto addToCartDto, Cart cart, Product product);
    Cart removeItemFromCart(Cart cart, Long productId);
    Cart updateCart(Cart cart, UpdateCartDto cartDto);
    Cart getLoggedInUserCart(Authentication auth);
}
