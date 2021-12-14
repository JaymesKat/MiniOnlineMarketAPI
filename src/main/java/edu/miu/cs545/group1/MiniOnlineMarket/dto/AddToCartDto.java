package edu.miu.cs545.group1.MiniOnlineMarket.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AddToCartDto {
    private Long id;
    private @NotNull Long productId;
    private @NotNull Integer quantity;

    @Override
    public String toString() {
        return "CartDto{" +
                "id=" + id +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ",";
    }
}
