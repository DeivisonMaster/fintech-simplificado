package br.com.picpay.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class ServicoAutorizadorIndisponivel extends PicPayExcecao {

	private static final long serialVersionUID = 1L;
	private int status = 0;
	
	public ServicoAutorizadorIndisponivel(int status) {
		this.status = status;
	}
	
	public ServicoAutorizadorIndisponivel() {
	}
	
	@Override
	public ProblemDetail toProblemDetail() {
		var pb = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		pb.setStatus(status);
		return pb;
	}
}
