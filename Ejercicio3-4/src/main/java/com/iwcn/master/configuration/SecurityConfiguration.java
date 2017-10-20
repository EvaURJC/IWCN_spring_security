package com.iwcn.master.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public CustomAuthenticationProvider authenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
    	// NO REQUIERE AUTENTICACION
        http.authorizeRequests().antMatchers("/").permitAll();
        http.authorizeRequests().antMatchers("/login").permitAll();
        http.authorizeRequests().antMatchers("/salir").permitAll();

        // REQUIERE AUTENTICACION
        http.authorizeRequests().anyRequest().authenticated();

        // FORMULARIO PARA INICIAR SESION
        http.formLogin().loginPage("/login");
        http.formLogin().usernameParameter("nombreUsuario");
        http.formLogin().passwordParameter("contUsuario");
        http.formLogin().defaultSuccessUrl("/principal");
        http.formLogin().failureUrl("/login?error");

        // SALIR DE LA APLICACION
        http.logout().logoutUrl("/salir");
        http.logout().logoutSuccessUrl("/salir");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        // Authorization
    	auth.authenticationProvider(authenticationProvider);

    }

}
