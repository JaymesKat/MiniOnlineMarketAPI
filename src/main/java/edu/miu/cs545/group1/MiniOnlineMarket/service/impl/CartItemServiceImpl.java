package edu.miu.cs545.group1.MiniOnlineMarket.service.impl;

import edu.miu.cs545.group1.MiniOnlineMarket.domain.Cart;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.CartItem;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.Product;
import edu.miu.cs545.group1.MiniOnlineMarket.repository.CartItemRepo;
import edu.miu.cs545.group1.MiniOnlineMarket.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired private CartItemRepo cartItemRepo;

    @Override
    public CartItem saveCartItem(CartItem cartItem) {
        return cartItemRepo.save(cartItem);
    }

    @Override
    public CartItem findById(Long cartId) {
        Optional<CartItem> ci = cartItemRepo.findById(cartId);
        if (!ci.isPresent()) throw new IllegalArgumentException("Cart Item of id "+ cartId +" does not exist !");
        return ci.get();
    }

    @Override
    public void deleteCartItem(Long itemId) {
        CartItem ci = this.findById(itemId);
        cartItemRepo.delete(ci);
    }

    @Override
    public CartItem updateCartItem(Cart cart, CartItem cartItem) {
        return null;
    }

    @Override
    public List<CartItem> findAll() {
        return cartItemRepo.findAll();
    }

    @Override
    public CartItem findByProduct(Product product) {
        return cartItemRepo.findByProduct(product);
    }

    @Override
    public CartItem findByCart(Cart cart) {
        return cartItemRepo.findByCart(cart);
    }

    @Override
    public void deleteByProductId(Long productId) {
        cartItemRepo.deleteByProductId(productId);
    }
}
