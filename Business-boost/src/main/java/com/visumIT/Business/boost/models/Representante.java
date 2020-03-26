package com.visumIT.Business.boost.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import lombok.Data;

/* Author: kaique
 * 26/03/2020
 * Classe para representar a tabela de representante do banco
 * Alterado:
 * */


@Entity(name="Representante")
@Table(name="tbl_representante")
@Data
public class Representante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nome", columnDefinition = "VARCHAR(40)")
	private String nome;
	
	@Email
	@Column(name="email",columnDefinition = "VARCHAR(40)")
	private String email;
	
	@Column(name="senha", columnDefinition = "VARCHAR(150)")
	private String senha;
	
	@Column(name="foto", columnDefinition = "VARCHAR(40)")
	private String foto;
	
	//relação
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "representante")
	@Column(name = "telefone", columnDefinition = "VARCHAR(20)")
	private List<Telefone> telefone = new  ArrayList<>();
	
	@Column(name="cpf", columnDefinition="VARCHAR(20)")
	private String cpf;
	
	@Column(name="data_nascimento", columnDefinition="VARCHAR(10)")
	private Date dataNascimento;
	
	@Column(name="sexo", columnDefinition="VARCHAR(1)")
	private String sexo;
	
	@Column(name="descricao")
	private String descricao;
}