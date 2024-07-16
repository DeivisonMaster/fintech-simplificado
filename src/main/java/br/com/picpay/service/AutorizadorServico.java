package br.com.picpay.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.picpay.exception.ServicoAutorizadorIndisponivel;
import br.com.picpay.model.dto.client.AutorizadorDTO;
import br.com.picpay.service.client.Autorizador;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AutorizadorServico {
	
	@Autowired
	private Autorizador autorizador;
	
	public boolean autorizador() {
		log.info("Iniciando Serviço Autorizador...");
		
		ResponseEntity<AutorizadorDTO> autoriza = autorizador.autoriza();
		
		if(!autoriza.getStatusCode().equals(HttpStatus.OK)) {
			throw new ServicoAutorizadorIndisponivel(autoriza.getStatusCodeValue());
		}
		
		if(Objects.isNull(autoriza.getBody())) {
			throw new ServicoAutorizadorIndisponivel();
		}
		
		return autoriza.getBody().data().authorization();
	}
}
