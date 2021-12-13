package edu.miu.cs545.group1.MiniOnlineMarket.domain;

import edu.miu.cs545.group1.MiniOnlineMarket.util.LocalDateTimeAttributeConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

//    @DateTimeFormat(pattern = "MM-dd-yyyy hh:mm:ss")
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime dateCreated;

    @OneToMany(mappedBy="order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    @PrePersist
    public void prePersist() {
        if(status == null) status = OrderStatus.PENDING;
    }
}
