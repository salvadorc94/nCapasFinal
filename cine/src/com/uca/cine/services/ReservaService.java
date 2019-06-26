package com.uca.cine.services;

import java.util.List;

import com.uca.cine.domain.Reserva;

public interface ReservaService {
public List<Reserva> listar();
	
	public Reserva obtenerUno(int id);
	 
	public void insertarActualizar(Reserva r);
}
