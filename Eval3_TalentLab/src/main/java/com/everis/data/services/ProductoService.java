package com.everis.data.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.data.models.Producto;
import com.everis.data.repositories.ProductoRepository;

@Service
public class ProductoService {
	
	@Autowired ProductoRepository productoRepository;

	public void save(@Valid Producto producto) {
		// TODO Auto-generated method stub
		productoRepository.save(producto);
		
	}

	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return productoRepository.findAll();
	}

}
