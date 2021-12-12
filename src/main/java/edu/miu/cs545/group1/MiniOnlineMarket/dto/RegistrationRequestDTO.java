package edu.miu.cs545.group1.MiniOnlineMarket.dto;

import edu.miu.cs545.group1.MiniOnlineMarket.config.UserRole;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.Address;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Data
public class RegistrationRequestDTO {
    String firstName;
    String lastName;

    @NotBlank
    String username;

    @NotBlank
    String password;

    @NotBlank
    @Email
    String email;

    @NotBlank
    String role;

    @Pattern(regexp = "[0-9\\+]+")
    String phone;

    @Valid @Null
    private Address shippingAddress;

    @Valid @Null
    private Address billingAddress;
}
