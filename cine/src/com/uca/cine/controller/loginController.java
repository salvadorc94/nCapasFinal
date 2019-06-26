package com.uca.cine.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.cine.domain.Usuario;
import com.uca.cine.domain.Departamento;
import com.uca.cine.domain.Municipio;
import com.uca.cine.domain.Pais;
import com.uca.cine.domain.Pelicula;
import com.uca.cine.services.DepartamentoService;
import com.uca.cine.services.MunicipioService;
import com.uca.cine.services.PaisService;
import com.uca.cine.services.PeliculaService;
import com.uca.cine.services.UsuarioService;


@Controller
public class loginController {

	@Autowired
	public UsuarioService usuarioservice;
	@Autowired
	public PeliculaService peliculaservice;
	@Autowired
	public PaisService paisservice;
	@Autowired
	public DepartamentoService depaserv;
	@Autowired
	public MunicipioService muniserv;
	
	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		Usuario user = new Usuario();
		mav.addObject("usuario",user);
		mav.setViewName("login");
		return mav;
	}
	
	@RequestMapping("/edit")
	public ModelAndView editar() {
		ModelAndView mav = new ModelAndView();
		Usuario user = new Usuario();
		List<Pais> paises = paisservice.listar();
		List<Departamento> deptos = depaserv.listar();
		List<Municipio> munis = muniserv.listar();
		mav.addObject("usuario", user);
		mav.addObject("listaPais",paises);
		mav.addObject("listaDepa", deptos);
		mav.addObject("listaMuni", munis);
		mav.setViewName("createU");
		return mav;
	}
	
	@RequestMapping("/save")
	public ModelAndView guardar(@Valid @ModelAttribute Usuario user, BindingResult result,@RequestParam("pais") int pais,@RequestParam("depa") int depa,@RequestParam("muni") int muni) {
		ModelAndView mav = new ModelAndView();
		//if(result.hasErrors()) {
		//	mav.setViewName("createU");
		//	return mav;
		//}else {
			user.setEstado(false);
			user.setSaldo(20);
			user.setPais(paisservice.getOne(pais));
			user.setMunicipio(muniserv.getOne(muni));
			user.setDepartamento(depaserv.getOne(depa));
			user.setFecha(user.getFecha());
			usuarioservice.insertarActualizarUsuario(user);
		//}
		
		
		//Usuario usuario = new Usuario();
		//mav.addObject("usuario", usuario);
		mav.setViewName("login");
		return mav;
	}
	
	@RequestMapping("/login")
	public ModelAndView validarLogin(@Valid @ModelAttribute Usuario user, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasFieldErrors("nombreusuario") || result.hasFieldErrors("contraseniausuario") ) {
			mav.setViewName("login");
			return mav;
		}else{
			boolean results = false;
			Usuario usuario = null;
			List<Pelicula> peliculas = null;
			try {
				results = usuarioservice.validarUsuario(user.getNombreusuario(), user.getContraseniausuario());
				usuario = usuarioservice.findByNombreusuarioAndContraseniausuario(user.getNombreusuario(), user.getContraseniausuario());
				peliculas = peliculaservice.listar();
			}catch (Exception e){
				
			}
			
			if(results) {
				//mav.addObject("usuario",usuario);
				//mav.addObject("Pelicula", peliculas);
				mav.setViewName("listadoPeli");
			}else {
				mav.addObject("mal","Credenciales invalidas o Usuario Inactivo Contactar Admin");
				
				mav.setViewName("login");
			}
		}
		return mav;
	}
	
}
