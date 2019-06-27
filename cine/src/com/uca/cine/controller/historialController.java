package com.uca.cine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.cine.domain.Historial;
import com.uca.cine.domain.Usuario;
import com.uca.cine.services.HistorialService;
import com.uca.cine.services.UsuarioService;

@Controller
public class historialController {
	
	@Autowired
	private UsuarioService usuarioservice;
	@Autowired
	private HistorialService hservice;
	
	@RequestMapping("/filtro")
	public ModelAndView historial(@RequestParam("cu") Integer cu,@RequestParam("fechaI") String fi, @RequestParam("fechaF") String ff) {
		ModelAndView mav = new ModelAndView();
		List<Historial> historial = null;
		Usuario user = null;
		try {
			user = usuarioservice.obtenerUsuario(cu);
			historial = hservice.filtrarFechas(cu, fi, ff);
		}catch(Exception e) {}
		
		mav.addObject("usuario",user);
		mav.addObject("historial",historial);
		mav.setViewName("listadoHistorial");
		return mav;
	}

}
