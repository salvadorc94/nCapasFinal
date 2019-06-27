package com.uca.cine.services;

import java.util.List;


import com.uca.cine.domain.Historial;

public interface HistorialService {
	public List<Historial> listarFunciones();
	
	public Historial obtenerFuncion(int id);
	 
	public void insertarActualizarHistorial(Historial h);
}
