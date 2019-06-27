package com.uca.cine.controller;

import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.cine.domain.Funcion;
import com.uca.cine.domain.Historial;
import com.uca.cine.domain.Pelicula;
import com.uca.cine.domain.Reserva;
import com.uca.cine.domain.Usuario;
import com.uca.cine.services.FuncionService;
import com.uca.cine.services.HistorialService;
import com.uca.cine.services.PeliculaService;
import com.uca.cine.services.ReservaService;
import com.uca.cine.services.UsuarioService;


@Controller
public class reservaController {
	
	@Autowired
	public UsuarioService usuarioservice;
	@Autowired
	public PeliculaService peliculaservice;
	@Autowired
	public FuncionService funcionservice;
	@Autowired
	public ReservaService reservaservice;
	@Autowired
	public HistorialService hservice;
	
	@RequestMapping("/reservar")
	public ModelAndView reservar(@ModelAttribute Reserva res, BindingResult result,@RequestParam("cp") int cp,@RequestParam("cu") int cu,@RequestParam("fu") int fu) {
		ModelAndView mav = new ModelAndView();
		Usuario user = null;
		Pelicula peli = null;
		Funcion funcion = null;
		try {
			user = usuarioservice.obtenerUsuario(cu);
			peli = peliculaservice.obtenerUno(cp);
			funcion = funcionservice.obtenerFuncion(fu);
		}catch(Exception e) {}
		mav.addObject("usuario", user);
		mav.addObject("pelicula", peli);
		mav.addObject("funcion",funcion);
		mav.setViewName("reservaForm");
		return mav;
	}
	
	
	@RequestMapping("/reservaResumen")
	public ModelAndView reservaValid(@Valid @ModelAttribute Reserva res, BindingResult result,@RequestParam("cp") int cp,@RequestParam("cu") int cu,@RequestParam("fu") int fu) {
		ModelAndView mav = new ModelAndView();
		Usuario user = null;
		Pelicula peli = null;
		Funcion funcion = null;
		if(result.hasErrors()) {
			try {
				user = usuarioservice.obtenerUsuario(cu);
				peli = peliculaservice.obtenerUno(cp);
				funcion = funcionservice.obtenerFuncion(fu);
			}catch(Exception e) {}
			mav.addObject("usuario", user);
			mav.addObject("pelicula", peli);
			mav.addObject("funcion",funcion);
			mav.setViewName("reservaForm");
			return mav;
		}else {
			try {
				user = usuarioservice.obtenerUsuario(cu);
				peli = peliculaservice.obtenerUno(cp);
				funcion = funcionservice.obtenerFuncion(fu);
			}catch(Exception e) {}
			
			res.setSaldorestante(user.getSaldo() - res.getSaldoutilizar());
			int total = res.getNasientosreserva()*3;
			float granTotal = total-res.getSaldoutilizar();
			
			mav.addObject("granTotal", granTotal);
			mav.addObject("reserva",res);
			mav.addObject("usuario", user);
			mav.addObject("pelicula", peli);
			mav.addObject("funcion",funcion);
			mav.setViewName("reservaSave");
		}
		return mav;
	}
	
	@RequestMapping("/guardarReserva")
	public ModelAndView guardar(@RequestParam("cu") int cu,@RequestParam("fu") int fu,
			@RequestParam("nasientos") int nasientos, @RequestParam("saldoU") int saldoU, @RequestParam("saldoR") int saldoR) {
		ModelAndView mav = new ModelAndView();
		List<Pelicula> peliculas = null;
		Usuario user = null;
		Funcion funcion = null;
				try {
					user = usuarioservice.obtenerUsuario(cu);
					funcion = funcionservice.obtenerFuncion(fu);
					peliculas = peliculaservice.listar();
				}catch(Exception e) {}
		
				/////////////PREPARO LA RESERVA PARA GUARDARLA//////////////////
				Reserva reserva = new Reserva();
				reserva.setFuncion(funcion);
				reserva.setNasientosreserva(nasientos);
				reserva.setSaldorestante(saldoR);
				reserva.setSaldoutilizar(saldoU);
				String dia, mes,annio;
				Calendar c = Calendar.getInstance();
				dia = Integer.toString(c.get(Calendar.DATE));
				mes =Integer.toString(c.get(Calendar.MONTH)+1);
				annio = Integer.toString(c.get(Calendar.YEAR));
				String fecha = annio.concat("-"+mes+"-"+dia);
				reserva.setFechareserva(fecha);
				reserva.setUsuario(user);
				///////////////////////PREPARO HISTORIAL PARA GUARDARLA///////////////////
				Historial historial = new Historial();
				historial.setReserva(reserva);
				historial.setUsuario(user);
				//////////////////////QUITO ASIENTOS DE RESERVA Y SALDO DE USUARIO////////////////////
				int asientos = funcion.getAsientos();
				funcion.setAsientos(asientos-nasientos);
				user.setSaldo(saldoR);
				
				
				///////////////////////////////GUARDO E INSERTO TO DO LO NECESARIO///////////////
				try {
					reservaservice.insertarActualizar(reserva);
					hservice.insertarActualizarHistorial(historial);
					funcionservice.insertarActualizarFuncion(funcion);
					usuarioservice.insertarActualizarUsuario(user);
				}catch(Exception e) {}
		mav.addObject("usuario",user);
		mav.addObject("peliculas", peliculas);
		mav.setViewName("listadoPeli");
		return mav;
	}
	
}
