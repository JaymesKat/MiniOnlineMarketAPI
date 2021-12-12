package edu.miu.cs545.group1.MiniOnlineMarket.config;

public enum UserPermission {
    PRODUCT_READ("product:read"),
    PRODUCT_WRITE("product:write"),
    PRODUCT_REVIEW_READ("productreview:read"),
    PRODUCT_REVIEW_WRITE("productreview:write"),
    ORDER_READ("order:read"),
    ORDER_WRITE("order:write"),
    CART_READ("cart:read"),
    CART_WRITE("cart:write");

    private final String permission;

    UserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
