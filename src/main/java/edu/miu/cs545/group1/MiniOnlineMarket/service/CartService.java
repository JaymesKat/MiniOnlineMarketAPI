package edu.miu.cs545.group1.MiniOnlineMarket.service;

import edu.miu.cs545.group1.MiniOnlineMarket.domain.Buyer;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.Cart;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.Product;
import edu.miu.cs545.group1.MiniOnlineMarket.dto.AddToCartDto;
import edu.miu.cs545.group1.MiniOnlineMarket.dto.UpdateCartDto;


public interface CartService {
    Cart findByOwner(Buyer buyer);
    Cart findById(Long cartId);
    void addItemToCart(AddToCartDto addToCartDto, Cart cart, Product product);
    void removeItemFromCart(Long cartId, Long productId);
//    void updateCart(Cart cart, AddToCartDto cartDto);
    Cart updateCartDto(Cart cart, UpdateCartDto cartDto);
    public Cart findByOwnerId(Long ownerId);
}
