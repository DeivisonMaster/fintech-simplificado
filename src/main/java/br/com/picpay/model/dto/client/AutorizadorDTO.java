package br.com.picpay.model.dto.client;

public record AutorizadorDTO(
		String status,
		Dados data) {
	
		public record Dados(
			boolean authorization
		) {
	}

}
