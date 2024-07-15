package br.com.picpay.model;

public enum TipoUsuario {
	COMUM(1, "Comun"),
	LOJISTA(2, "Lojista");
	
	private int id;
	private String descricao;

	private TipoUsuario(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	public int getId() {
		return id;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
