package edu.miu.cs545.group1.MiniOnlineMarket.config;

import edu.miu.cs545.group1.MiniOnlineMarket.config.jwt.JwtConfig;
import edu.miu.cs545.group1.MiniOnlineMarket.config.jwt.JwtTokenVerifier;
import edu.miu.cs545.group1.MiniOnlineMarket.config.jwt.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.crypto.SecretKey;
import java.util.List;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;
    private final SecretKey secretKey;
    private final JwtConfig jwtConfig;

    @Autowired
    public SecurityConfig(PasswordEncoder passwordEncoder, UserDetailsService userDetailsService, SecretKey secretKey, JwtConfig jwtConfig) {
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
        this.secretKey = secretKey;
        this.jwtConfig = jwtConfig;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        final JwtAuthenticationFilter authenticationFilter = new JwtAuthenticationFilter(authenticationManager(), jwtConfig, secretKey);
        authenticationFilter.setFilterProcessesUrl("/api/auth/login");

        httpSecurity.headers().frameOptions().disable();

        httpSecurity
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/v1/**").permitAll()
                .antMatchers(SecurityConstants.REGISTER_URL).permitAll()
                .antMatchers(SecurityConstants.LOGIN_URL).permitAll()
                .antMatchers(SecurityConstants.H2_CONSOLE_URL).permitAll()
                .antMatchers(SecurityConstants.ADMIN_MANAGEMENT_ENDPOINTS).hasRole(UserRole.ADMIN.name())
                .anyRequest()
                .authenticated()
                .and()
                .addFilter(authenticationFilter)
                .addFilterAfter(new JwtTokenVerifier(secretKey, jwtConfig), JwtAuthenticationFilter.class)
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .cors()
                .configurationSource(corsConfigurationSource());
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder);
        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedMethods(List.of(
                HttpMethod.GET.name(),
                HttpMethod.PUT.name(),
                HttpMethod.POST.name(),
                HttpMethod.DELETE.name()
        ));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration.applyPermitDefaultValues());
        return source;
    }
}
