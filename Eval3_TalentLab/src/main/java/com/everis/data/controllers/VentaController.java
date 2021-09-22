package com.everis.data.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.everis.data.services.VentaService;

@Controller
public class VentaController {
	
	@Autowired
	VentaService ventaService;
	
	@RequestMapping("/venta")
	public String venta() {
		return null;
	}
	

}
