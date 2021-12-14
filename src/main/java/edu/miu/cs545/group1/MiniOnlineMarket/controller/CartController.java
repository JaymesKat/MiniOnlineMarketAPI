package edu.miu.cs545.group1.MiniOnlineMarket.controller;

import edu.miu.cs545.group1.MiniOnlineMarket.domain.*;
import edu.miu.cs545.group1.MiniOnlineMarket.dto.AddToCartDto;
import edu.miu.cs545.group1.MiniOnlineMarket.dto.UpdateCartDto;
import edu.miu.cs545.group1.MiniOnlineMarket.service.BuyerService;
import edu.miu.cs545.group1.MiniOnlineMarket.service.CartItemService;
import edu.miu.cs545.group1.MiniOnlineMarket.service.ProductService;
import edu.miu.cs545.group1.MiniOnlineMarket.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/carts")
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private ProductService productService;

    @Autowired
    private BuyerService buyerService;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/{buyerId}/items")
    public  void addToCart(@RequestBody AddToCartDto addToCartDto, Authentication auth, @PathVariable Long buyerId) {
//        String username = auth.getPrincipal().toString();
//        User user = ((MyUserDetails)userDetailsService.loadUserByUsername(username)).getUser();

        Product product = productService.findById(addToCartDto.getProductId());
        Buyer buyer = buyerService.findById(buyerId);
        Cart cart = cartService.findByOwner(buyer);
        if(cart==null) cart = new Cart(buyer);
        cartService.addItemToCart(addToCartDto, cart, product);
    }

    @DeleteMapping("/{cartId}/products/{productId}")
    public void removeItemFromCart(@PathVariable Long cartId,@PathVariable Long productId) {
        cartService.removeItemFromCart(cartId, productId);
    }

    @PutMapping("/{cartId}")
    public void updateCart(@PathVariable Long cartId,@RequestBody UpdateCartDto cartDto) {
        Cart cart = cartService.findById(cartId);
        cartService.updateCartDto(cart, cartDto);
    }
}
