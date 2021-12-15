package edu.miu.cs545.group1.MiniOnlineMarket.config;

import org.springframework.http.HttpMethod;

public class SecurityConstants {
    public static final int PASSWORD_ENCODER_STRENGTH = 10;
    public static final String H2_CONSOLE_URL = "/h2-console/**";
    public static final String CART_ENDPOINTS = "/api/v1/cart/**";
    public static String LOGIN_URL = "/api/auth/login";
    public static String REGISTER_URL = "/api/auth/register";
    public static String ADMIN_MANAGEMENT_ENDPOINTS = "/management/api/**";
    public static String ROLE_ADMIN="ROLE_ADMIN";
    public static String ROLE_BUYER="ROLE_BUYER";
    public static String ROLE_SELLER="ROLE_SELLER";
}
