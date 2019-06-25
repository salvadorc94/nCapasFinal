package com.uca.cine.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.cine.domain.Usuario;
import com.uca.cine.services.UsuarioService;

@Controller
public class loginController {

	@Autowired
	public UsuarioService usuarioservice;
	
	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		Usuario user = new Usuario();
		mav.addObject("user",user);
		mav.setViewName("login");
		return mav;
	}
	
	
	@RequestMapping("/login")
	public ModelAndView validarLogin(@Valid @ModelAttribute Usuario user, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName("login");
		}else{
			boolean results = false;
			
			try {
				results = usuarioservice.validarUsuario(user.getNombreusuario(), user.getContraseniausuario());
			}catch (Exception e){
				
			}
			
			if(results) {
				mav.addObject("mal","ENTRO");
				mav.setViewName("login");
			}else {
				mav.addObject("mal","NO ENTRO");
				mav.setViewName("login");
			}
		}
		return mav;
	}
	
}
