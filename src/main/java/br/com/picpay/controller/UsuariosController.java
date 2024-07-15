package br.com.picpay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.picpay.model.Usuario;
import br.com.picpay.model.dto.UsuarioDTO;
import br.com.picpay.service.UsuarioServico;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
	
	@Autowired
	private UsuarioServico usuarioServico;
	
	@PostMapping
	public ResponseEntity<Usuario> novo(@RequestBody UsuarioDTO usuarioDTO){
		return ResponseEntity.ok(usuarioServico.novo(usuarioDTO));
	}
	
}
