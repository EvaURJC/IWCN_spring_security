package com.iwcn.master.pro;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Producto {
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	public String codigo;
	
	public String nombre;
	
	public String descripcion;
	
	public Integer precio;
	
	protected Producto () {
		
	}
	
}
