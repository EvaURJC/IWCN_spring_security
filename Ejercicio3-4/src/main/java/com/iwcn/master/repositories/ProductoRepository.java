package com.iwcn.master.repositories;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.iwcn.master.pro.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Integer> {
	
	Producto findById (int id);
	
	@Query(value = "SELECT * FROM PRODUCTO", nativeQuery = true)
	List<Producto> selectAll();
	
	@Transactional
	@Modifying
	@Query("UPDATE Producto p SET p.codigo=?1, p.nombre=?2, p.descripcion=?3, p.precio=?4 WHERE p.id=?5")
	int setNewProducto(String codigo, String nombre, String descripcion, Integer precio, int id);

}
