package com.everis.data.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.everis.data.models.Producto;
import com.everis.data.services.ProductoService;

@Controller
public class ProductoController {
	
	@Autowired
	ProductoService productoService;
	
	@RequestMapping("/producto")
	public String producto(Model model) {
		model.addAttribute("lista_productos", productoService.findAll());
		return "producto.jsp";
	}
	
	@RequestMapping(value="/producto/crear", method=RequestMethod.POST)
	public String crear(@ModelAttribute("producto") Producto producto) {
		productoService.save(producto);
		return "redirect:/producto";
	}
	
	

}
