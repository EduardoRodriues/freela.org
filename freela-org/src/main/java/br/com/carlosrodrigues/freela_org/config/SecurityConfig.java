/*package br.com.carlosrodrigues.freela_org.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/admin/**").authenticated() // Protege rotas específicas
                .anyRequest().permitAll()
            )
            .formLogin(login -> login
                .defaultSuccessUrl("/admin/servico", true)
            )
            .logout(logout -> logout.permitAll());
        
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        var user = User.withUsername("user")
                .password("{noop}password") // Use {noop} para desativar a criptografia (apenas para testes)
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }
} */