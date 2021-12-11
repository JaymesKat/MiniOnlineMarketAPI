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
public class Seller extends Person {

    private boolean isApproved;

    @OneToMany(mappedBy="seller", cascade = CascadeType.PERSIST)
    List<Product> products;

    @OneToMany
    @JoinColumn(name="seller_id")
    List<Sale> sales;

}
