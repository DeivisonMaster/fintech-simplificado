package br.com.picpay.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.picpay.model.Carteira;
import br.com.picpay.model.Usuario;
import br.com.picpay.repository.CarteiraRepositorio;

@Service
public class CarteiraServico {

	@Autowired
	private CarteiraRepositorio carteiraRepositorio;
	
	public void novaCarteira(Usuario usuarioSalvo) {
		Carteira carteira = new Carteira();
		carteira.setSaldo(BigDecimal.ZERO);
		carteira.setUsuario(usuarioSalvo);

		carteiraRepositorio.save(carteira);
	}

	public Optional<Carteira> buscaCarteiraAssociadaAoUsuario(Long id) {
		return carteiraRepositorio.buscaCarteiraPorIdUsuario(id);
	}

}
