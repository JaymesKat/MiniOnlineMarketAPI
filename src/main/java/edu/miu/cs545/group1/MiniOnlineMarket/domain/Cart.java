package edu.miu.cs545.group1.MiniOnlineMarket.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_date")
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private LocalDate dateCreated;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="owner_id")
    private Buyer owner;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CartItem> items;

    public Cart(Buyer owner){
        this.owner = owner;
        items = new ArrayList<>();
    }
    public Cart addCartItem(CartItem cartItem){
        for (CartItem c : items){
            if (cartItem.getProduct() == c.getProduct()) {
                cartItem.setQuantity(cartItem.getQuantity() + c.getQuantity());
                items.remove(c);
                items.add(cartItem);
                cartItem.setCart(this);
                return this;
            }
        }
        items.add(cartItem);
        cartItem.setCart(this);
        return this;
    }
    public void removeCartItem(CartItem cartItem){
        items.remove(cartItem);
    }
}