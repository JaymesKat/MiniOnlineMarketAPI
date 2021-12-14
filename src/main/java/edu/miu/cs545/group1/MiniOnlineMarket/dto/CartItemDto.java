package edu.miu.cs545.group1.MiniOnlineMarket.dto;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.Cart;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.Product;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CartItemDto {
    private Long id;
    private @NotNull Integer quantity;
    private @NotNull Long productId;

    @Override
    public String toString() {
        return "CartDto{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", productId=" + productId +
                '}';
    }
}