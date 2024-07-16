package br.com.picpay.model.dto;

import java.math.BigDecimal;

public record TransferenciaRequisicaoDTO(BigDecimal valor, Long idPagador, Long idRecebedor) {

}
