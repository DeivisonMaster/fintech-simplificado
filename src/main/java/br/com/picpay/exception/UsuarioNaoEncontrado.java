package br.com.picpay.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class UsuarioNaoEncontrado extends PicPayExcecao{

	private static final long serialVersionUID = 1L;
	
	@Override
	public ProblemDetail toProblemDetail() {
		var pb = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
		pb.setTitle("Usuario não encontrado");
		return pb;
	}
}
