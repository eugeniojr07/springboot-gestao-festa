package com.eugenio.festa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="convidados")
public class Convidado {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="quantidade_acompanhantes")
	private Integer quantidade_acompanhantes;
	
	public Convidado() {
		
	}
	
	public Convidado(String nome, Integer quantidade_acompanhantes) {
		super();
		this.nome = nome;
		this.quantidade_acompanhantes = quantidade_acompanhantes;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getQuantidade_acompanhantes() {
		return quantidade_acompanhantes;
	}
	public void setQuantidadeAcompanhantes(Integer quantidade_acompanhantes) {
		this.quantidade_acompanhantes = quantidade_acompanhantes;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
