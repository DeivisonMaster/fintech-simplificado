package br.com.picpay.model.dto;

import java.math.BigDecimal;

public record TransferenciaRespostaDTO(BigDecimal valor, Long idPagador, Long idRecebedor) {

}
