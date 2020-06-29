package com.scg.docking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

public class SecurityConfig {

	@Bean
	SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) throws Exception {
		http.csrf().disable().authorizeExchange().pathMatchers("/**").permitAll().anyExchange().authenticated().and()
				.cors().and().oauth2ResourceServer().jwt();
		return http.build();
	}
}