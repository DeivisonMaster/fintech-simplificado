package br.com.picpay.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")
@EqualsAndHashCode(of = "id")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "sobrenome")
	private String sobreNome;
	
	@Column(name = "cpf", unique = true)
	private String cpf;
	
	@Column(name = "cnpj", unique = true)
	private String cnpj;
	
	@Column(name = "email", unique = true)
	private String email;
	
	@Column(name = "senha")
	private String senha;
	
	@Column(name = "tipo_usuario")
	@Enumerated(EnumType.STRING)
	private TipoUsuario tipoUsuario;
}
