package com.carlos.security.model.dao;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.carlos.security.model.entity.Usuario;
import org.springframework.data.repository.query.Param;

public interface UsuarioDao extends PagingAndSortingRepository <Usuario, Long>{

	public Usuario findByUsername(@Param("nombre") String username);
	

}
