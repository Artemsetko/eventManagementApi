package com.asiet.springdatarest.eventmanagementapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.authorizeHttpRequests()
				.requestMatchers(HttpMethod.POST)
				.hasRole("ADMIN")
				.requestMatchers(HttpMethod.PUT)
				.hasRole("ADMIN")
				.requestMatchers(HttpMethod.PATCH)
				.hasRole("ADMIN")
				.requestMatchers(HttpMethod.DELETE)
				.hasRole("ADMIN")
				.and()
				.httpBasic();

		http.csrf().disable();
		return http.build();
	}

}
