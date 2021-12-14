package edu.miu.cs545.group1.MiniOnlineMarket.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Buyer extends Person {

    @OneToOne
    @Valid
    private Address shippingAddress;

    @OneToOne
    @Valid
    private Address billingAddress;

    @JsonIgnore
    @ManyToMany(mappedBy="followers")
    List<Seller> followees;

    @OneToMany
    @JoinColumn(name="buyer_id")
    List<Order> orders;

    @OneToOne(mappedBy="owner")
    public Cart cart;

    public void addFollowee(Seller seller){
        followees.add(seller);
        seller.addFollower(this);
    }

    public void removeFollowee(Seller seller){
        followees.remove(seller);
        seller.removeFollower(this);
    }

}
