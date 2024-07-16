package br.com.picpay.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.picpay.model.dto.client.AutorizadorDTO;

@FeignClient(name = "ServicoAutorizador", url = "https://util.devi.tools/api/v2/authorize")
public interface Autorizador {
	
	@GetMapping
	public ResponseEntity<AutorizadorDTO> autoriza();
}	
