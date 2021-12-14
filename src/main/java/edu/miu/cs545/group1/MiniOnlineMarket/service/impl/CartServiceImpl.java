package edu.miu.cs545.group1.MiniOnlineMarket.service.impl;

import edu.miu.cs545.group1.MiniOnlineMarket.domain.Buyer;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.Cart;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.CartItem;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.Product;
import edu.miu.cs545.group1.MiniOnlineMarket.dto.AddToCartDto;
import edu.miu.cs545.group1.MiniOnlineMarket.dto.CartDto;
import edu.miu.cs545.group1.MiniOnlineMarket.dto.CartItemDto;
import edu.miu.cs545.group1.MiniOnlineMarket.dto.UpdateCartDto;
import edu.miu.cs545.group1.MiniOnlineMarket.repository.CartRepo;
import edu.miu.cs545.group1.MiniOnlineMarket.service.CartItemService;
import edu.miu.cs545.group1.MiniOnlineMarket.service.CartService;
import edu.miu.cs545.group1.MiniOnlineMarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepo cartRepo;
    @Autowired
    private CartItemService cartItemService;
    @Autowired
    private ProductService productService;

    @Override
    public Cart findByOwner(Buyer buyer) {
        return cartRepo.findByOwner(buyer);
    }

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
    public void addItemToCart(AddToCartDto addToCartDto, Cart cart, Product product) {
        CartItem cartItem = new CartItem(product, addToCartDto.getQuantity(), cart);
        List<CartItem> cartItems = cart.getItems();
        for (CartItem item : cartItems) {
            if (item.getCart() == cart && item.getProduct() == product) {
                cartItemService.deleteCartItem(cartItem.getId());
            }
        }
        cart.addCartItem(cartItem);
        cartRepo.save(cart);
    }

    @Override
    public Cart updateCartDto(Cart cart, UpdateCartDto cartDto) {
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
    public Cart findByOwnerId(Long ownerId) {
        return cartRepo.findByOwnerId(ownerId);
    }

    @Override
    public void removeItemFromCart(Long cartId, Long productId) {
        List<CartItem> list = cartItemService.findAll();
        for (CartItem c : list) {
            if (c.getCart().getId() == cartId && c.getProduct().getId() == productId){
                cartItemService.deleteCartItem(c.getId());
                Cart cart = cartRepo.findById(cartId).get();
                List<CartItem> items = cart.getItems();
                items.remove(c);
                cart.setItems(items);
                cartRepo.save(cart);
            }
        }
    }

    @Override
    public void deleteCart(Buyer buyer) {
        Cart cart = this.findByOwner(buyer);
        cartRepo.delete(cart);
    }
}

