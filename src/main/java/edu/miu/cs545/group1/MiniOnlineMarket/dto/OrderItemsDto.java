package edu.miu.cs545.group1.MiniOnlineMarket.dto;

import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class OrderItemsDto {
    private @NotNull double price;
    private @NotNull int quantity;
    private @NotNull int orderId;
    private @NotNull int productId;
}