package br.com.picpay.exception;

import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GerenciadorDeExcecoes {
	
	@ExceptionHandler(PicPayExcecao.class)
	public ProblemDetail gerenciaPicPayExcecao(PicPayExcecao e) {
		return e.toProblemDetail();
	}
	
}
