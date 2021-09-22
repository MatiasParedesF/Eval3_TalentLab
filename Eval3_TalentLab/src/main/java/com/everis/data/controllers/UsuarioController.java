package com.everis.data.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.data.models.Usuario;
import com.everis.data.services.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping("/")
	public String index() {
		return "login.jsp";
	}
	
	@RequestMapping("/registro")
	public String registro(@ModelAttribute("usuario") Usuario usuario ) {
		return "registro.jsp";
	}
	
	@RequestMapping("/ingresar")
	public String ingresar(@RequestParam("email") String email,
			@RequestParam("password") String password,
			HttpSession session) {
		boolean existeUsuario = usuarioService.validaUsuario(email,password);
		
		if(existeUsuario) {
			Usuario usuario=usuarioService.findByEmail(email);
			//guardando un elemento en session
			session.setAttribute("usuarioId", usuario.getId());
			return "redirect:/inicio";
		}
		return "login.jsp";
	}
	
	@RequestMapping( value="/registrar", method=RequestMethod.POST)
	public String registrar(@Valid @ModelAttribute("usuario") Usuario usuario) {
		//Realizar validaciones
		usuarioService.save(usuario);
		
		return "redirect:ingresar";
	}
	
	@RequestMapping("/inicio")
	public String inicio(HttpSession session) {
		//valida el acceso a rutas
		if(session.getAttribute("usuarioId")!=null) {
			return "redirect:/producto";
		}
		return "redirect:/login";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		if(session.getAttribute("userId")!=null) {
			session.invalidate();
		}
		return "redirect:/login";
	}
	
	
}
