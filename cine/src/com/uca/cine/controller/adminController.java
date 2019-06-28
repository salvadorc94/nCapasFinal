package com.uca.cine.controller;

import java.util.Calendar;
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
import com.uca.cine.domain.Horariof;
import com.uca.cine.domain.Municipio;
import com.uca.cine.domain.Pais;
import com.uca.cine.domain.Pelicula;
import com.uca.cine.domain.Tipo;
import com.uca.cine.domain.Tipof;
import com.uca.cine.domain.Usuario;
import com.uca.cine.services.DepartamentoService;
import com.uca.cine.services.FuncionService;
import com.uca.cine.services.HorariofService;
import com.uca.cine.services.MunicipioService;
import com.uca.cine.services.PaisService;
import com.uca.cine.services.PeliculaService;
import com.uca.cine.services.TipofService;
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
	@Autowired
	public HorariofService horariofservice;
	@Autowired 
	private TipofService tipofservice;
	@Autowired
	private FuncionService funcionservice;
	
	@RequestMapping("/adminU")
	public ModelAndView adminU() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("usuario",usuarioservice.listar());
		mav.setViewName("adminModulo");
		return mav;
	}
	
	
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
			List<Usuario> users = null;
			try {
				users = usuarioservice.listar();
			}catch(Exception e) {}
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
			mav.addObject("usuario", users);
			mav.setViewName("adminModulo");
		}
		return mav;
	}
	
	//crearH crearP crearF
	
	@RequestMapping("/adminT")
	public ModelAndView adminT(@RequestParam("cu") int cu) {
		ModelAndView mav = new ModelAndView();
		List<Tipof> tipos = tipofservice.listar();
		Usuario user = usuarioservice.obtenerUsuario(cu);
		mav.addObject("tipos",tipos);
		mav.addObject("usuario", user);
		mav.setViewName("/adminForms/listaTipo");
		return mav;
	}
	@RequestMapping("/createT")
	public ModelAndView createT(@RequestParam("cu") int ti) {
		ModelAndView mav = new ModelAndView();
		Tipof tipo = new Tipof();
		Usuario user = usuarioservice.obtenerUsuario(ti);
		mav.addObject("tipof",tipo);
		mav.addObject("usuario", user);
		mav.setViewName("/adminForms/crearTipof");
		return mav;
	}
	@RequestMapping("/editT")
	public ModelAndView editT(@RequestParam("cu") int ti,@RequestParam("c") int c) {
		ModelAndView mav = new ModelAndView();
		Tipof tipo = tipofservice.obtenerUno(c);
		Usuario user = usuarioservice.obtenerUsuario(ti);
		mav.addObject("tipof",tipo);
		mav.addObject("usuario", user);
		mav.setViewName("/adminForms/crearTipof");
		return mav;
	}
	@RequestMapping("/saveT")
	public ModelAndView saveT(@Valid @ModelAttribute Tipof tipof, BindingResult result,@RequestParam("cu") int cu,@RequestParam("usuarioC") String C) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName("/adminForms/crearTipof");
			return mav;
		}else {
			if(tipof.getUsuariocreacion() == null || tipof.getUsuariocreacion() == "" ) {
				tipof.setUsuariocreacion(C);
				String dia, mes,annio;
				Calendar c = Calendar.getInstance();
				dia = Integer.toString(c.get(Calendar.DATE));
				mes =Integer.toString(c.get(Calendar.MONTH)+1);
				annio = Integer.toString(c.get(Calendar.YEAR));
				String fecha = annio.concat("-"+mes+"-"+dia);
				tipof.setFechacreacion(fecha);
			}else {
				tipof.setUsuariomodificacion(C);
				String dia, mes,annio;
				Calendar c = Calendar.getInstance();
				dia = Integer.toString(c.get(Calendar.DATE));
				mes =Integer.toString(c.get(Calendar.MONTH)+1);
				annio = Integer.toString(c.get(Calendar.YEAR));
				String fecha = annio.concat("-"+mes+"-"+dia);
				tipof.setFechamodificacion(fecha);
			}
			try {
				tipofservice.insertarActualizar(tipof);
			}catch(Exception e) {}
		}
		List<Tipof> tipos = tipofservice.listar();
		Usuario user = usuarioservice.obtenerUsuario(cu);
		mav.addObject("tipos",tipos);
		mav.addObject("usuario", user);
		mav.setViewName("/adminForms/listaTipo");
		return mav;
	}
	
	
	@RequestMapping("/adminH")
	public ModelAndView adminH(@RequestParam("cu") int cu) {
		ModelAndView mav = new ModelAndView();
		List<Horariof> horarios = horariofservice.listar();
		Usuario user = usuarioservice.obtenerUsuario(cu);
		mav.addObject("horario",horarios);
		mav.addObject("usuario", user);
		mav.setViewName("/adminForms/listaHorario");
		return mav;
	}
	@RequestMapping("/createH")
	public ModelAndView createH(@RequestParam("cu") int ti) {
		ModelAndView mav = new ModelAndView();
		Horariof horariof = new Horariof();
		Usuario user = usuarioservice.obtenerUsuario(ti);
		mav.addObject("horariof",horariof);
		mav.addObject("usuario", user);
		mav.setViewName("/adminForms/crearHorariof");
		return mav;
	}
	@RequestMapping("/editH")
	public ModelAndView editH(@RequestParam("cu") int ti,@RequestParam("c") int c) {
		ModelAndView mav = new ModelAndView();
		Horariof horariof = horariofservice.obtenerUno(c);
		Usuario user = usuarioservice.obtenerUsuario(ti);
		mav.addObject("horariof",horariof);
		mav.addObject("usuario", user);
		mav.setViewName("/adminForms/crearHorariof");
		return mav;
	}
	@RequestMapping("/saveH")
	public ModelAndView saveH(@Valid @ModelAttribute Horariof horariof, BindingResult result,@RequestParam("cu") int cu,@RequestParam("usuarioC") String C) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName("/adminForms/crearHorariof");
			return mav;
		}else {
			if(horariof.getUsuariocreacion() == null || horariof.getUsuariocreacion() == "" ) {
				horariof.setUsuariocreacion(C);
				String dia, mes,annio;
				Calendar c = Calendar.getInstance();
				dia = Integer.toString(c.get(Calendar.DATE));
				mes =Integer.toString(c.get(Calendar.MONTH)+1);
				annio = Integer.toString(c.get(Calendar.YEAR));
				String fecha = annio.concat("-"+mes+"-"+dia);
				horariof.setFechacreacion(fecha);
			}else {
				horariof.setUsuariomodificacion(C);
				String dia, mes,annio;
				Calendar c = Calendar.getInstance();
				dia = Integer.toString(c.get(Calendar.DATE));
				mes =Integer.toString(c.get(Calendar.MONTH)+1);
				annio = Integer.toString(c.get(Calendar.YEAR));
				String fecha = annio.concat("-"+mes+"-"+dia);
				horariof.setFechamodificacion(fecha);
			}
			try {
				horariofservice.insertarActualizar(horariof);
			}catch(Exception e) {}
		}
		List<Horariof> horarios = horariofservice.listar();
		Usuario user = usuarioservice.obtenerUsuario(cu);
		mav.addObject("horario",horarios);
		mav.addObject("usuario", user);
		mav.setViewName("/adminForms/listaHorario");
		return mav;
	}
	
	
	@RequestMapping("/adminP")
	public ModelAndView adminP(@RequestParam("cu") int cu) {
		ModelAndView mav = new ModelAndView();
		List<Pelicula> peliculas = peliculaservice.listar();
		Usuario user = usuarioservice.obtenerUsuario(cu);
		mav.addObject("peliculas",peliculas);
		mav.addObject("usuario", user);
		mav.setViewName("/adminForms/listaPelicula");
		return mav;
	}
	@RequestMapping("/createP")
	public ModelAndView createP(@RequestParam("cu") int ti) {
		ModelAndView mav = new ModelAndView();
		Pelicula pelicula = new Pelicula();
		Usuario user = usuarioservice.obtenerUsuario(ti);
		mav.addObject("pelicula",pelicula);
		mav.addObject("usuario", user);
		mav.setViewName("/adminForms/crearPelicula");
		return mav;
	}
	@RequestMapping("/editP")
	public ModelAndView editP(@RequestParam("cu") int ti,@RequestParam("c") int c) {
		ModelAndView mav = new ModelAndView();
		Pelicula pelicula = peliculaservice.obtenerUno(c);
		Usuario user = usuarioservice.obtenerUsuario(ti);
		mav.addObject("pelicula",pelicula);
		mav.addObject("usuario", user);
		mav.setViewName("/adminForms/crearPelicula");
		return mav;
	}
	@RequestMapping("/saveP")
	public ModelAndView saveP(@Valid @ModelAttribute Pelicula pelicula, BindingResult result,@RequestParam("cu") int cu,@RequestParam("usuarioC") String C) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName("/adminForms/crearPelicula");
			return mav;
		}else {
			if(pelicula.getUsuariocreacion() == null || pelicula.getUsuariocreacion() == "" ) {
				pelicula.setUsuariocreacion(C);
				String dia, mes,annio;
				Calendar c = Calendar.getInstance();
				dia = Integer.toString(c.get(Calendar.DATE));
				mes =Integer.toString(c.get(Calendar.MONTH)+1);
				annio = Integer.toString(c.get(Calendar.YEAR));
				String fecha = annio.concat("-"+mes+"-"+dia);
				pelicula.setFechacreacion(fecha);
			}else {
				pelicula.setUsuariomodificacion(C);
				String dia, mes,annio;
				Calendar c = Calendar.getInstance();
				dia = Integer.toString(c.get(Calendar.DATE));
				mes =Integer.toString(c.get(Calendar.MONTH)+1);
				annio = Integer.toString(c.get(Calendar.YEAR));
				String fecha = annio.concat("-"+mes+"-"+dia);
				pelicula.setFechamodificacion(fecha);
			}
			try {
				peliculaservice.insertarActualizar(pelicula);
			}catch(Exception e) {}
		}
		List<Pelicula> peliculas = peliculaservice.listar();
		Usuario user = usuarioservice.obtenerUsuario(cu);
		mav.addObject("peliculas",peliculas);
		mav.addObject("usuario", user);
		mav.setViewName("/adminForms/listaPelicula");
		return mav;
	}
	
	
	
	
}
