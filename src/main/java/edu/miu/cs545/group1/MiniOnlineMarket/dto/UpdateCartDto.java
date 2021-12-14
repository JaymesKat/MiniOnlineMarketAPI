package edu.miu.cs545.group1.MiniOnlineMarket.dto;
import lombok.Data;

import java.util.List;

@Data
public class UpdateCartDto {
    private List<CartItemDto> cartItems;
}
