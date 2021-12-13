package edu.miu.cs545.group1.MiniOnlineMarket.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seller extends Person {

    private boolean isApproved;

    @JsonIgnore
    @OneToMany(mappedBy="seller", cascade = CascadeType.PERSIST)
    List<Product> products;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name="seller_id")
    List<Sale> sales;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name="seller_followers",
            joinColumns = {@JoinColumn(name = "seller_id")},
            inverseJoinColumns = {@JoinColumn(name = "buyer_id")})
    List<Buyer> followers;

    public void addFollower(Buyer buyer) {
        followers.add(buyer);
    }

    public void removeFollower(Buyer buyer) {
        followers.remove(buyer);
    }
}
