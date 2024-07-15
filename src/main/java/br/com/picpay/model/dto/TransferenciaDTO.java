package br.com.picpay.model.dto;

import java.math.BigDecimal;

public record TransferenciaDTO(BigDecimal valor, Long idPagador, Long idRecebedor) {

}
