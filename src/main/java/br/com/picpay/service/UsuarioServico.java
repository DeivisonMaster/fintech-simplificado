package br.com.picpay.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.picpay.exception.DadosUnicosExistentesExcecao;
import br.com.picpay.model.TipoUsuario;
import br.com.picpay.model.Usuario;
import br.com.picpay.model.dto.UsuarioDTO;
import br.com.picpay.repository.UsuarioRepositorio;

@Service
public class UsuarioServico {
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	private CarteiraServico carteiraServico;

	public Usuario novo(UsuarioDTO usuarioDTO) {
		Optional<Usuario> usuarioPesquisa = usuarioRepositorio.findByCpfOrEmail(usuarioDTO.cpf(), usuarioDTO.email());
		if(usuarioPesquisa.isPresent()) {
			throw new DadosUnicosExistentesExcecao("CPF ou e-mail já estão cadastrados no sistema!");
		}
		
		Usuario usuario = new Usuario();
		usuario.setNome(usuarioDTO.nome());
		usuario.setSobreNome(usuarioDTO.sobreNome());
		usuario.setCpf(usuarioDTO.cpf());
		usuario.setCnpj(usuarioDTO.cnpj());
		usuario.setTipoUsuario(usuarioDTO.tipoUsuario().toUpperCase().equals(TipoUsuario.COMUM.toString()) ? TipoUsuario.COMUM : TipoUsuario.LOJISTA);
		usuario.setEmail(usuarioDTO.email());
		usuario.setSenha(usuarioDTO.senha());
		
		Usuario usuarioSalvo = usuarioRepositorio.save(usuario);
		
		carteiraServico.novaCarteira(usuarioSalvo);
		
		return usuarioSalvo;
	}
	
	public Optional<Usuario> buscaPorId(Long id) {
		return usuarioRepositorio.findById(id);
	}
	
	
}
