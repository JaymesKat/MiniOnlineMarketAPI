package edu.miu.cs545.group1.MiniOnlineMarket.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int quantity;
    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name="order_id")
    @JsonIgnore
    private Order order;

    @OneToOne
    @JoinColumn(name="product_id")
    private Product product;

    @PrePersist
    public void prePersist() {
        if(status == null) status = OrderStatus.PENDING;
    }
}
