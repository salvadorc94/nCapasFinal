package com.uca.cine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.cine.domain.Funcion;
import com.uca.cine.domain.HorarioxFuncion;
import com.uca.cine.domain.Pelicula;
import com.uca.cine.domain.Usuario;
import com.uca.cine.services.PeliculaService;
import com.uca.cine.services.UsuarioService;

@Controller
public class peliculaController {
	
	@Autowired
	public PeliculaService peliculaservice;
	@Autowired
	public UsuarioService usuarioservice;
	
	@RequestMapping("/peliculas")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		List<Pelicula> peliculas = null;
		try {
			peliculas = peliculaservice.listar();
		}catch (Exception e){}
		
		mav.addObject("peliculas", peliculas);
		mav.setViewName("listadoPeli");
		return mav;
	}
	
	@RequestMapping("/view")
	public ModelAndView view(@RequestParam("cp") Integer cpeli, @RequestParam("cu") Integer cuser) {
		ModelAndView mav = new ModelAndView();
		List<Funcion> funciones = null;
		Pelicula pelicula = null;
		Usuario u = null;
		try {
			funciones = peliculaservice.obtenerUno(cpeli).getFunciones();
			pelicula = peliculaservice.obtenerUno(cpeli);
			u = usuarioservice.obtenerUsuario(cuser);
			
		}catch(Exception e) {}
		mav.addObject("funciones",funciones);
		mav.addObject("pelicula",pelicula);
		mav.addObject("usuario", u);
		mav.setViewName("listadoFunciones");
		return mav;
	}
	
}
