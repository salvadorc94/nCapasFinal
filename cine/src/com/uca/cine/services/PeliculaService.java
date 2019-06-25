package com.uca.cine.services;

import java.util.List;

import com.uca.cine.domain.Pelicula;


public interface PeliculaService {
	public List<Pelicula> listar();
	
	public Pelicula obtenerUno(int id);
	 
	public void insertarActualizar(Pelicula p);
}
