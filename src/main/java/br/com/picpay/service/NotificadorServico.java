package br.com.picpay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.picpay.model.dto.TransferenciaRequisicaoDTO;
import br.com.picpay.service.client.Notificador;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class NotificadorServico {
	
	@Autowired
	private Notificador notificador;
	
	
	public void notifica(TransferenciaRequisicaoDTO transferencia) {
		log.info("Enviando Notificação...");
		
		try {
			var resposta = notificador.notifica(transferencia);
			if(!resposta.getStatusCode().equals(HttpStatus.NO_CONTENT)) {
				log.info("Serviço indisponivel no momento ", resposta.getStatusCode());
			}
			
		} catch (Exception e) {
			log.error("Erro ao enviar Notificação", e);
		}
	}
}
