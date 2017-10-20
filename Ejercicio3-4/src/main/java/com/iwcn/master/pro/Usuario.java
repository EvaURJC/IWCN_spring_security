package com.iwcn.master.pro;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.GrantedAuthority;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Usuario {
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String nombre;
	
	private String cont;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private List<GrantedAuthority> roles;
	
	public Usuario () {
		
	}
	
	public Usuario (String nombre, String cont, List<GrantedAuthority> roles) {
		this.nombre = nombre;
		this.cont = new BCryptPasswordEncoder().encode(cont);
		this.roles = roles;
	}
	
	public String getPasswordHash() {
        return cont;
    }

    public void setPasswordHash(String passwordHash) {
        this.cont = passwordHash;
    }
    
}
