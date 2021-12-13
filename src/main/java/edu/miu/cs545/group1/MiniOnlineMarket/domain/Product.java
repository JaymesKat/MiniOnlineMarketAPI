package edu.miu.cs545.group1.MiniOnlineMarket.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.miu.cs545.group1.MiniOnlineMarket.util.LocalDateTimeAttributeConverter;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
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

//    @DateTimeFormat(pattern = "MM-dd-yyyy")
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime dateCreated;

    @ManyToOne
    @JoinColumn(name="seller_id")
    @JsonIgnore
    private Seller seller;

    @OneToMany(mappedBy="product")
    List<ProductReview> reviews;
}
