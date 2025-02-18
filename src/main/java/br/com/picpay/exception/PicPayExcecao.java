package br.com.picpay.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class PicPayExcecao extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ProblemDetail toProblemDetail() {
		var pb = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		pb.setTitle("Erro Interno do Servidor - PicPay");
		return pb;
	}
}
