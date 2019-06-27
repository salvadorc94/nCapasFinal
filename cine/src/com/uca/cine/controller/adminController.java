package com.uca.cine.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.cine.domain.Departamento;
import com.uca.cine.domain.Municipio;
import com.uca.cine.domain.Pais;
import com.uca.cine.domain.Tipo;
import com.uca.cine.domain.Usuario;
import com.uca.cine.services.DepartamentoService;
import com.uca.cine.services.MunicipioService;
import com.uca.cine.services.PaisService;
import com.uca.cine.services.PeliculaService;
import com.uca.cine.services.UsuarioService;

@Controller
public class adminController {
	
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
	
	@RequestMapping("/crearU")
	public ModelAndView crearU() {
		ModelAndView mav = new ModelAndView();
		Usuario user = new Usuario();
		List<Pais> paises = paisservice.listar();
		List<Departamento> deptos = depaserv.listar();
		List<Municipio> munis = muniserv.listar();
		mav.addObject("listaPais",paises);
		mav.addObject("listaDepa",deptos);
		mav.addObject("listaMuni",munis);
		mav.addObject("usuario",user);
		mav.setViewName("/adminForms/crearUsuario");
		return mav;
	}
	
	
	@RequestMapping("/editU")
	public ModelAndView editU(@RequestParam("cu") int cu) {
		ModelAndView mav = new ModelAndView();
		Usuario user = new Usuario();
		try {
			user = usuarioservice.obtenerUsuario(cu);
		}catch(Exception e) {}
		List<Pais> paises = paisservice.listar();
		List<Departamento> deptos = depaserv.listar();
		List<Municipio> munis = muniserv.listar();
		mav.addObject("listaPais",paises);
		mav.addObject("listaDepa",deptos);
		mav.addObject("listaMuni",munis);
		mav.addObject("usuario",user);
		mav.setViewName("/adminForms/crearUsuario");
		return mav;
	}
	
	@RequestMapping("/saveU")
	public ModelAndView guardar(@Valid @ModelAttribute Usuario user, BindingResult result,@RequestParam("pais") int pais,@RequestParam("depa") int depa,@RequestParam("muni") int muni,@RequestParam("tipo") String tipo) {
		ModelAndView mav = new ModelAndView();
		if(result.hasFieldErrors("nombre") || result.hasFieldErrors("apellido") || result.hasFieldErrors("fecha") || result.hasFieldErrors("direccion") || result.hasFieldErrors("nombreusuario") || result.hasFieldErrors("contraseniausuario")) {
			mav.setViewName("/adminForms/crearUsuario");
			return mav;
		}else {
			user.setPais(paisservice.getOne(pais));
			user.setMunicipio(muniserv.getOne(muni));
			user.setDepartamento(depaserv.getOne(depa));
			Tipo tipoU = new Tipo();
			tipoU.setPkidtipo(1);
			if(tipo.equals("Admin")) {
				user.setTipo(tipoU);
			}else {
				tipoU.setPkidtipo(2);
				user.setTipo(tipoU);
			}
			usuarioservice.insertarActualizarUsuario(user);
			mav.setViewName("login");
		}
		
		
		//Usuario usuario = new Usuario();
		//mav.addObject("usuario", usuario);
		mav.setViewName("login");
		return mav;
	}

}
