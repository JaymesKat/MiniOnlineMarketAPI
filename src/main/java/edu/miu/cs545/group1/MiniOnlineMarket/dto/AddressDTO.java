package edu.miu.cs545.group1.MiniOnlineMarket.dto;

import edu.miu.cs545.group1.MiniOnlineMarket.domain.Address;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
public class AddressDTO {
    private @NotNull @Valid Address shippingAddress;
    private @NotNull @Valid Address billingAddress;
}
