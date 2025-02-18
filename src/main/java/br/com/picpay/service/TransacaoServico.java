package br.com.picpay.service;


import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.picpay.exception.UsuarioNaoEncontrado;
import br.com.picpay.model.Carteira;
import br.com.picpay.model.Transacao;
import br.com.picpay.model.Usuario;
import br.com.picpay.model.dto.TransferenciaRequisicaoDTO;
import br.com.picpay.repository.TransacaoRepositorio;

@Service
public class TransacaoServico {
	
	@Autowired
	private TransacaoRepositorio transacaoRepositorio;
	
	@Autowired
	private UsuarioServico usuarioServico;
	
	@Autowired
	private CarteiraServico carteiraServico;
	
	@Autowired
	private AutorizadorServico autorizadorServico;
	
	@Autowired
	private NotificadorServico notificacaoServico;
	
	
	@Transactional
	public Transacao efetuaTransferencia(TransferenciaRequisicaoDTO transferencia) {
		Usuario usuarioPagador = usuarioServico.buscaPorId(transferencia.idPagador()).orElseThrow(UsuarioNaoEncontrado::new);
		Usuario usuarioRecebedor = usuarioServico.buscaPorId(transferencia.idRecebedor()).orElseThrow(UsuarioNaoEncontrado::new);
		
		Carteira carteiraPagador = carteiraServico.buscaCarteiraAssociadaAoUsuario(usuarioPagador.getId()).orElseThrow(CarteiraNaoEncontrada::new);
		Carteira carteiraRecebedor = carteiraServico.buscaCarteiraAssociadaAoUsuario(usuarioRecebedor.getId()).orElseThrow(CarteiraNaoEncontrada::new);
		
		validacoesParaTransferencia(transferencia, usuarioPagador, carteiraPagador);
		
		carteiraPagador.debito(transferencia.valor());
		carteiraRecebedor.credito(transferencia.valor());
		
		Transacao transacao = new Transacao(null, carteiraPagador, carteiraRecebedor, transferencia.valor());
		transacaoRepositorio.save(transacao);
		
		CompletableFuture.runAsync(() -> notificacaoServico.notifica(transferencia));
		
		return transacao;
	}


	private void validacoesParaTransferencia(TransferenciaRequisicaoDTO transferencia, Usuario usuarioPagador,
			Carteira carteiraPagador) {
		if(!usuarioPagador.isTransferenciaPermitida()) {
			throw new UsuarioNaoPermitidoRealizarTransferencia();
		}
		
		if(carteiraPagador.isSaldoSuficiente(transferencia.valor())) {
			throw new SaldoInsuficiente();
		}
		
		if(!autorizadorServico.autorizador()) {
			throw new TransacaoNaoAutorizada();
		}
	}
	
}
