package edu.miu.cs545.group1.MiniOnlineMarket.domain;

import edu.miu.cs545.group1.MiniOnlineMarket.config.UserRole;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;

    @Email
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;
    private boolean enabled;
}
