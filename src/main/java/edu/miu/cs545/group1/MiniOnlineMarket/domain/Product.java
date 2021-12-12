package edu.miu.cs545.group1.MiniOnlineMarket.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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

    @OneToMany(mappedBy="product")
    List<ProductReview> reviews;
}
