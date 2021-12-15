package edu.miu.cs545.group1.MiniOnlineMarket.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.miu.cs545.group1.MiniOnlineMarket.util.LocalDateTimeAttributeConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "created_date")
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime dateCreated;

//    @OneToOne
//    @JoinColumn(name="owner_id", referencedColumnName = "id")
//    @JsonIgnore
//    private Buyer

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<CartItem> items;

    public Cart addCartItem(CartItem cartItem){
        if(items==null) items = new ArrayList<CartItem>();
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
        if(items!=null) items.remove(cartItem);
    }
}