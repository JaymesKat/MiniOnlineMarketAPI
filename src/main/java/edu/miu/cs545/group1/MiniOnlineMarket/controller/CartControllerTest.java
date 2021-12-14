//package edu.miu.cs545.group1.MiniOnlineMarket.controller;
//
//import edu.miu.cs545.group1.MiniOnlineMarket.domain.Buyer;
//import edu.miu.cs545.group1.MiniOnlineMarket.domain.Product;
//import edu.miu.cs545.group1.MiniOnlineMarket.dto.AddToCartDto;
//import edu.miu.cs545.group1.MiniOnlineMarket.dto.CartDto;
//import edu.miu.cs545.group1.MiniOnlineMarket.service.AuthService;
//import edu.miu.cs545.group1.MiniOnlineMarket.service.ProductService;
//import edu.miu.cs545.group1.MiniOnlineMarket.service.impl.CartService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//
//    @RestController
//    @RequestMapping("/cart")
//    public class CartControllerTest {
//        @Autowired
//        private CartService cartService;
//
//        @Autowired
//        private ProductService productService;
//
//        @Autowired
//        private AuthService authenticationService;
//
//        @PostMapping("/add")
//        public ResponseEntity<CartDto> addToCart(@RequestBody AddToCartDto addToCartDto) {
//            Product product = productService.(addToCartDto.getProductId());
//            System.out.println("product to add"+  product.getName());
//            cartService.addToCart(addToCartDto, product, user);
//            return new ResponseEntity<>("", HttpStatus.CREATED);
//
//        }
//        @GetMapping("/")
//        public ResponseEntity<CartDto> getCartItems(@RequestParam("token") String token) {
//            CartDto cartDto = cartService.listCartItems(user);
//            return new ResponseEntity<CartDto>(cartDto,HttpStatus.OK);
//        }
//
//    }
