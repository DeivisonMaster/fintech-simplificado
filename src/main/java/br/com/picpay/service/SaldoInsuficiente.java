package br.com.picpay.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

import br.com.picpay.exception.PicPayExcecao;

public class SaldoInsuficiente extends PicPayExcecao {
	private static final long serialVersionUID = 1L;
	
	@Override
	public ProblemDetail toProblemDetail() {
		var pb = ProblemDetail.forStatus(HttpStatus.FORBIDDEN);
		pb.setTitle("Saldo insuficiente para realizar a transação");
		return pb;
	}
}
