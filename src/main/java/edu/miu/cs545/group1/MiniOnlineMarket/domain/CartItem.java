package edu.miu.cs545.group1.MiniOnlineMarket.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name="product_id")
    private Product product;

    private int quantity;

    @ManyToOne
    @JoinColumn(name="cart_id")
    private Cart cart;

    public CartItem(Product product, int quantity, Cart cart){
        this.cart = cart;
        this.product = product;
        this.quantity = quantity;
    }
}
