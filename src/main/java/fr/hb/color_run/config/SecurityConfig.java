package fr.hb.color_run.config;

import fr.hb.color_run.filters.JWTTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(jsr250Enabled = true)
public class SecurityConfig {

	@Autowired
	private JWTTokenFilter jwtTokenFilter;
	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
				.csrf(csrf -> csrf.disable())
				.headers(headers -> headers.frameOptions(frame -> frame.disable()))
				.authorizeHttpRequests(request -> request
//						.requestMatchers("/auth/login","/auth/register", "/index", "/participants/**").permitAll()
//						.requestMatchers("/admin/**").hasRole("ADMIN")
//						.requestMatchers("/organisateurs/**").hasRole("ORGANISATEUR")
//						.anyRequest().authenticated()
						.anyRequest().permitAll()
				)
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class)
//				.formLogin(form -> form
//						.loginPage("/auth/login") // prend le form ds thymleaf
//						.failureUrl("/auth/login?error=true")
//						//.defaultSuccessUrl("/participants/list", true) // si ca réussi j'envoie sur quelle page
//						.defaultSuccessUrl("/", true) // si ca réussi j'envoie sur quelle page
//						.permitAll()
//				)
				.logout(logout -> logout
						.logoutUrl("/logout")
						.logoutSuccessUrl("/")
						.permitAll()
				)
				.build();
	}

	
	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON) // une seule instance du passwEnc
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManager(
			PasswordEncoder passwordEncoder,
			UserDetailsService userDetailsService
	) throws Exception {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(passwordEncoder);
		return new ProviderManager(authProvider);
	}
}
