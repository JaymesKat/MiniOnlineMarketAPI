package edu.miu.cs545.group1.MiniOnlineMarket.dto;

import edu.miu.cs545.group1.MiniOnlineMarket.domain.Order;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class OrderDto {
    private Long id;
    private @NotNull Long userId;

    public OrderDto(Order order) {
        this.setId(order.getId());
    }
}
