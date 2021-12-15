package edu.miu.cs545.group1.MiniOnlineMarket.controller;

import edu.miu.cs545.group1.MiniOnlineMarket.auth.MyUserDetails;
import edu.miu.cs545.group1.MiniOnlineMarket.config.UserRole;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.*;
import edu.miu.cs545.group1.MiniOnlineMarket.dto.AddToCartDto;
import edu.miu.cs545.group1.MiniOnlineMarket.dto.CartDto;
import edu.miu.cs545.group1.MiniOnlineMarket.dto.UpdateCartDto;
import edu.miu.cs545.group1.MiniOnlineMarket.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @Autowired
    private BuyerService buyerService;

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<Cart> getCart(Authentication auth){
        Cart cart = cartService.getLoggedInUserCart(auth);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Cart> addToCart(@RequestBody AddToCartDto addToCartDto, Authentication auth) {
        Cart cart = cartService.addCart(addToCartDto, auth);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @DeleteMapping("/remove/{productId}")
    public ResponseEntity<Cart> removeItemFromCart(Authentication auth, @PathVariable Long productId) {
        Cart cart = cartService.getLoggedInUserCart(auth);
        cart = cartService.removeItemFromCart(cart, productId);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Cart> updateCart(Authentication auth,@RequestBody UpdateCartDto cartDto) {
        Cart cart = cartService.getLoggedInUserCart(auth);
        cart = cartService.updateCart(cart, cartDto);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }
}
