package edu.miu.cs545.group1.MiniOnlineMarket.config;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static edu.miu.cs545.group1.MiniOnlineMarket.config.UserPermission.*;

public enum UserRole {
    ADMIN(Sets.newHashSet()),
    BUYER(Sets.newHashSet(PRODUCT_READ, PRODUCT_REVIEW_WRITE, PRODUCT_REVIEW_READ, ORDER_WRITE, CART_READ, CART_WRITE)),
    SELLER(Sets.newHashSet(PRODUCT_WRITE, ORDER_READ, ORDER_WRITE));

    private final Set<UserPermission> permissions;

    UserRole(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<UserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }

        static public boolean isValid(String aRole) {
            UserRole[] roles = UserRole.values();
            for (UserRole role : roles)
                if (role.name().equals(aRole))
                    return true;
            return false;
        }
}
