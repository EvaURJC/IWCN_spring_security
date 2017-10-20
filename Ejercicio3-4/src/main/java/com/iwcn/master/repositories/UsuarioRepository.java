package com.iwcn.master.repositories;

import org.springframework.data.repository.CrudRepository;
import com.iwcn.master.pro.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
	
	Usuario findByNombre (String nombre);	

}
