package br.com.picpay.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class DadosUnicosExistentesExcecao extends PicPayExcecao {
	private static final long serialVersionUID = 1L;
	private String detalhe;
	
	public DadosUnicosExistentesExcecao(String detalhe) {
		this.detalhe = detalhe;
	}
	
	@Override
	public ProblemDetail toProblemDetail() {
		var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
		pb.setTitle("Dados do Usuario já existem no Sistema");
		pb.setDetail(detalhe);
		return pb;
	}

}
