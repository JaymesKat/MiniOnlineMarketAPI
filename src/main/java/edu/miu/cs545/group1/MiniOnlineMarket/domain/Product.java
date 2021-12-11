package edu.miu.cs545.group1.MiniOnlineMarket.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String description;
    private String code;
    private double price;
    private int quantity;
    private LocalDate dateCreated;

    @ManyToOne
    @JoinColumn(name="seller_id")
    private Seller seller;
}
