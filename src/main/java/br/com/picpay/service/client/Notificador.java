package br.com.picpay.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.picpay.model.dto.TransferenciaRequisicaoDTO;

@FeignClient(name = "notificador", url = "https://util.devi.tools/api/v1/notify")
public interface Notificador {
	
	@PostMapping
	ResponseEntity<Void> notifica(@RequestBody TransferenciaRequisicaoDTO transferencia);
}
