package com.iwcn.master.configuration;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.iwcn.master.pro.Usuario;
import com.iwcn.master.repositories.UsuarioRepository;

public class DatabaseLoader {

	@Autowired
	private UsuarioRepository userRepository;
	
	@PostConstruct
	private void initDatabase() {
		GrantedAuthority[] usuarioRoles = { new SimpleGrantedAuthority("ROLE_USER")};
		userRepository.save(new Usuario("user", "user1", Arrays.asList(usuarioRoles)));
	
		GrantedAuthority[] administradorRoles = { new SimpleGrantedAuthority("ROLE_USER"), new SimpleGrantedAuthority("ROLE_ADMIN")};
		userRepository.save(new Usuario("root", "root1", Arrays.asList(administradorRoles)));
	}
	
}
