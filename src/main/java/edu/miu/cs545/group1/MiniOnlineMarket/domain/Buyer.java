package edu.miu.cs545.group1.MiniOnlineMarket.domain;

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
    @NotNull @Valid
    private Address shippingAddress;

    @OneToOne
    @NotNull @Valid
    private Address billingAddress;

    @ManyToMany(mappedBy="followers")
    List<Seller> followees;

}
