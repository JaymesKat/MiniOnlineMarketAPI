package edu.miu.cs545.group1.MiniOnlineMarket.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String title;
    private String description;
    private String code;
    @NotNull
    private double price;
    private int quantity;

    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private LocalDate dateCreated;

    @ManyToOne
    @JoinColumn(name="seller_id")
    private Seller seller;
}
