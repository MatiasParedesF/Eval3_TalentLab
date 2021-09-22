package com.everis.data.services;

import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.data.models.Usuario;
import com.everis.data.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
		public void save(@Valid Usuario usuario) {
			String hashed = BCrypt.hashpw(usuario.getPassword(),BCrypt.gensalt());
			usuario.setPassword(hashed);
			usuarioRepository.save(usuario);
		}
		
		public boolean validaUsuario(String email, String password) {
			return true;
		}

		public Usuario findByEmail(String email) {
			// TODO Auto-generated method stub
			return usuarioRepository.findByEmail(email);
		}
}
