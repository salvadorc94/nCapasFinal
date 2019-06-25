package com.uca.cine.services;

import java.util.List;

import com.uca.cine.domain.Usuario;

public interface UsuarioService {
	
	public boolean validarUsuario(String username, String password);
	
	public void insertarActualizarUsuario(Usuario u);
	
	public Usuario obtenerUsuario(int id);

}
