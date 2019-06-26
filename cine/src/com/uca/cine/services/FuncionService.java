package com.uca.cine.services;

import java.util.List;

import com.uca.cine.domain.Funcion;

public interface FuncionService {
	public List<Funcion> listarFunciones();
	
	public Funcion obtenerFuncion(int id);
	 
	public void insertarActualizarFuncion(Funcion f);

}
