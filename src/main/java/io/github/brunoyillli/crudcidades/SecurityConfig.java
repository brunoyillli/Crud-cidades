package io.github.brunoyillli.crudcidades;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    protected SecurityFilterChain filter(HttpSecurity http) throws Exception {
        return http
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/login**").permitAll()
                .requestMatchers("/").hasAnyRole("listar", "admin")	
                .requestMatchers("/criar", "/excluir", "/preparaAlterar", "/alterar", "/mostrar").hasRole("admin")
                .anyRequest().denyAll()
                .and()
                .formLogin()
                .loginPage("/login.html").permitAll()
                .and()
                .logout().permitAll()
                .and()
                .build();
    }

    @Bean
    public PasswordEncoder cifrador() {
        return new BCryptPasswordEncoder();
    }
    
    @EventListener(classes = InteractiveAuthenticationSuccessEvent.class)
    public void printUsuarioAtual(InteractiveAuthenticationSuccessEvent event) {
    	String usuario = event.getAuthentication().getName();
    	System.out.println(usuario);
    }
}