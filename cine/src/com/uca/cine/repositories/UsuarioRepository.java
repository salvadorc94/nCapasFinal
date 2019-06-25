package com.uca.cine.repositories;
import com.uca.cine.domain.Usuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	@Query(value = "SELECT * FROM USUARIO WHERE usuario_nombre = :username AND contrasenia_usuario= :pass",nativeQuery = true)
	public List<Usuario> findNombreUsuario(@Param("username") String user,@Param("pass") String password);
}

