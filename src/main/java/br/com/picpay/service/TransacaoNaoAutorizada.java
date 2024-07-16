package br.com.picpay.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

import br.com.picpay.exception.PicPayExcecao;

public class TransacaoNaoAutorizada extends PicPayExcecao {
	private static final long serialVersionUID = 1L;
	
	@Override
	public ProblemDetail toProblemDetail() {
		var pb = ProblemDetail.forStatus(HttpStatus.FORBIDDEN);
		return pb;
	}
	
}
