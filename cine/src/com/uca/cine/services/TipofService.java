package com.uca.cine.services;

import java.util.List;

import com.uca.cine.domain.Tipof;

public interface TipofService {
public List<Tipof> listar();
	
	public Tipof obtenerUno(int id);
	 
	public void insertarActualizar(Tipof t);
}
