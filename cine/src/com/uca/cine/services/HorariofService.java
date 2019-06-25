package com.uca.cine.services;

import java.util.List;

import com.uca.cine.domain.Horariof;

public interface HorariofService {
public List<Horariof> listar();
	
	public Horariof obtenerUno(int id);
	 
	public void insertarActualizar(Horariof h);

}
