package com.uca.cine.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uca.cine.domain.Usuario;
import com.uca.cine.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImp implements UsuarioService {

	@Autowired
	private UsuarioRepository usuariorepo;
	
	@Override
	public boolean validarUsuario(String username, String password) {
		List<Usuario> usuarios = usuariorepo.findByUsuarioAndClave(username, password);
		if(usuarios != null) {
			if(usuarios.size()==1 && usuarios.get(0).getEstado() == true) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}

}
