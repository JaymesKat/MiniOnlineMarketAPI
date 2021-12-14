package edu.miu.cs545.group1.MiniOnlineMarket.dto;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.CartItem;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
public class CartDto {
    private List<CartItemDto> cartItems;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date;

    public CartDto(List<CartItemDto> cartItem, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        this.cartItems = cartItem;
        this.date = date;
    }
}