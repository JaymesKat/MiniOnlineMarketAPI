package edu.miu.cs545.group1.MiniOnlineMarket.config;

import org.springframework.http.HttpMethod;

public class SecurityConstants {
    public static final int PASSWORD_ENCODER_STRENGTH = 10;
    public static final String H2_CONSOLE_URL = "/h2-console/**";
    public static String LOGIN_URL = "/api/auth/login";
    public static String ADMIN_MANAGEMENT_ENDPOINTS = "/management/api/**";
}
