package br.com.picpay.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name = "transacao")
@EqualsAndHashCode(of = "id")
public class Transacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_pagador")
	private Carteira pagador;
	
	@ManyToOne
	@JoinColumn(name = "id_recebedor")
	private Carteira recebedor;
	
	@Column(name = "valor")
	private BigDecimal valor = BigDecimal.ZERO;
}
