package br.com.picpay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.picpay.model.Transacao;
import br.com.picpay.model.dto.TransferenciaRequisicaoDTO;
import br.com.picpay.service.TransacaoServico;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {
	
	@Autowired
	private TransacaoServico servico;
	
	
	@PostMapping
	public ResponseEntity<Transacao> efetuaTransferencia(@RequestBody TransferenciaRequisicaoDTO transferencia){
		return ResponseEntity.ok(servico.efetuaTransferencia(transferencia));
	}
}	
