package edu.miu.cs545.group1.MiniOnlineMarket.service.impl;

import edu.miu.cs545.group1.MiniOnlineMarket.domain.*;
import edu.miu.cs545.group1.MiniOnlineMarket.dto.AddToCartDto;
import edu.miu.cs545.group1.MiniOnlineMarket.dto.CartDto;
import edu.miu.cs545.group1.MiniOnlineMarket.dto.CartItemDto;
import edu.miu.cs545.group1.MiniOnlineMarket.dto.UpdateCartDto;
import edu.miu.cs545.group1.MiniOnlineMarket.repository.CartRepo;
import edu.miu.cs545.group1.MiniOnlineMarket.service.BuyerService;
import edu.miu.cs545.group1.MiniOnlineMarket.service.CartItemService;
import edu.miu.cs545.group1.MiniOnlineMarket.service.CartService;
import edu.miu.cs545.group1.MiniOnlineMarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepo cartRepo;
    @Autowired
    private BuyerService buyerService;

    @Autowired
    private CartItemService cartItemService;
    @Autowired
    private ProductService productService;

    @Override
    public Cart findById(Long cartId) {
        Optional<Cart> cart = cartRepo.findById(cartId);
        if (cart.isPresent()) {
            return cart.get();
        } else {
            throw new IllegalArgumentException("Order item of id " + cartId + " does not exist !");
        }
    }

    @Override
    public Cart createCart(Buyer buyer) {
        Cart cart = new Cart();
        cart.setDateCreated(LocalDateTime.now());
        cart.setOwner(buyer);
        cart = cartRepo.save(cart);
        return cart;
    }

    @Override
    public Cart getOrCreateCart(Buyer buyer) {
        return findByOwner(buyer);
    }

    @Override
    public Cart addItemToCart(AddToCartDto addToCartDto, Cart cart, Product product) {
        CartItem cartItem = new CartItem(product, addToCartDto.getQuantity(), cart);
        List<CartItem> cartItems = cart.getItems();
        for (CartItem item : cartItems) {
            if (item.getCart() == cart && item.getProduct() == product) {
                cartItemService.deleteCartItem(cartItem.getId());
            }
        }
        cart.addCartItem(cartItem);
        cartRepo.save(cart);
        return cart;
    }

    @Override
    public Cart updateCart(Cart cart, UpdateCartDto cartDto) {
        List<CartItem> listItems = new ArrayList<>();
        for (CartItemDto dto : cartDto.getCartItems()){
            if (dto.getProductId() != null) {
                for (CartItem ci : cartItemService.findAll()){
                    if (dto.getProductId() == ci.getProduct().getId())
                        cartItemService.deleteCartItem(ci.getId());
                }
                Product product = productService.findById(dto.getProductId());
                CartItem cartItem = new CartItem(product, dto.getQuantity(), cart);
                listItems.add(cartItem);
            }
        }
        cart.setItems(listItems);
        return cartRepo.save(cart);
    }

    @Override
    public Cart findByOwner(Buyer buyer) {
        return cartRepo.findByOwner(buyer).orElse(createCart(buyer));
    }

    @Override
    public Cart removeItemFromCart(Cart cart, Long productId) {
        List<CartItem> list = cartItemService.findAll();
        for (CartItem c : list) {
            if (c.getCart().getId() == cart.getId() && c.getProduct().getId() == productId){
                cartItemService.deleteCartItem(c.getId());
                cart = cartRepo.findById(cart.getId()).get();
                List<CartItem> items = cart.getItems();
                items.remove(c);
                cart.setItems(items);
                cartRepo.save(cart);
            }
        }
        return cart;
    }


    public Cart getLoggedInUserCart(Authentication auth) {
        Buyer buyer = buyerService.getLoggedInBuyer(auth);
        return findByOwner(buyer);
    }

}

