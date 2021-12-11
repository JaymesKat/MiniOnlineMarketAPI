package edu.miu.cs545.group1.MiniOnlineMarket.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name="owner_id")
    private Buyer owner;

    @OneToMany
    @JoinColumn(name="cart_id")
    private List<CartItem> items;
}