package com.iwcn.master.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.iwcn.master.pro.Usuario;
import com.iwcn.master.repositories.UsuarioRepository;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UsuarioRepository userRepository;

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {

        String nombreUsuario = authentication.getName();
        String contUsuario = (String) authentication.getCredentials();

        Usuario usuario = userRepository.findByNombre(nombreUsuario);

        if (usuario == null) {
            throw new BadCredentialsException("Usuario no encontrado");
        }
        if (!new BCryptPasswordEncoder().matches(contUsuario,
        		usuario.getPasswordHash())) {
            throw new BadCredentialsException("Contraseña errónea");
        }
        
        List<GrantedAuthority> roles = usuario.getRoles();

        return new UsernamePasswordAuthenticationToken(nombreUsuario, contUsuario,
                roles);
    }

    @Override
    public boolean supports(Class<?> arg0) {
        return true;
    }
}
