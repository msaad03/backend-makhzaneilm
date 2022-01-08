package io.magazine.makhzaneilm.configuration.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.header.writers.StaticHeadersWriter;

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${anonymous.urls}")
    private String[] anonymousUrls;

    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    protected void configure(
            HttpSecurity httpSecurity
    ) throws Exception {
        httpSecurity
                .cors()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .and()
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers(anonymousUrls)
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

//        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
//        httpSecurity.addFilterBefore(filterChainExceptionHandler, JwtRequestFilter.class);
//        httpSecurity.addFilterBefore(requestFilter, FilterChainExceptionHandler.class);
//
//        if (cspEnabled) {
//            httpSecurity.headers()
//                    .addHeaderWriter(
//                            new StaticHeadersWriter("X-Content-Security-Policy", cspConfiguration));
//        }

        //Spring Security Propagation With @Async
        SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
    }

}
