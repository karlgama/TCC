//classe representa o modelo da entidade empresa

package com.visumIT.Business.boost.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_empresa")
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "razao", columnDefinition = "VARCHAR(60)")
	private String razaoSocial;
		
	@Column(name = "nome_fantasia", columnDefinition = "VARCHAR(60)")
	private String nome;
	
	@Column(name = "cnpj", columnDefinition = "VARCHAR(14)")
	private String cnpj;
	
	@Column(name = "fundacao", columnDefinition = "VARCHAR(30)")
	private Long fundacao;
	
	@Column(name = "endereco", columnDefinition = "VARCHAR(60)")
	private String endereco;
	
	@Column(name = "email", columnDefinition = "VARCHAR(40)")
	private String email;
	
	@Column(name = "telefone_opcao1", columnDefinition = "VARCHAR(15)")
	private String telefoneOpcao1;
	
	@Column(name = "telefone_opcao2", columnDefinition = "VARCHAR(15)")
	private String telefoneOpcao2;
	
	@Column(name = "telefone_opcao3", columnDefinition = "VARCHAR(15)")
	private String telefoneOpcao3;
	
	@Column(name = "nicho", columnDefinition = "TEXT()")
	private String nicho;
	
	@Column(name = "porte_empresa", columnDefinition = "VARCHAR()")
	private String porteEmpresa;
	
	@Column(name = "numero_funcionarios", columnDefinition = "VARCHAR(10)")
	private Integer numeroFuncionarios;
	
	@Column(name = "senha", columnDefinition = "VARCHAR(150)")
	private String senha;
	
	@Column(name = "descricao", columnDefinition = "TEXT()")
	private String descricao;
	
	@Column(name = "logo", columnDefinition = "VARCHAR(40)")
	private String logo;
	
	@Column(name = "imagem", columnDefinition = "VARCHAR(40)")
	private String imagem;
	
	@Column(name = "metodo_pagamento", columnDefinition = "VARCHAR(40)")
	private String metodoPagamento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Long getFundacao() {
		return fundacao;
	}

	public void setFundacao(Long fundacao) {
		this.fundacao = fundacao;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefoneOpcao1() {
		return telefoneOpcao1;
	}

	public void setTelefoneOpcao1(String telefoneOpcao1) {
		this.telefoneOpcao1 = telefoneOpcao1;
	}

	public String getTelefoneOpcao2() {
		return telefoneOpcao2;
	}

	public void setTelefoneOpcao2(String telefoneOpcao2) {
		this.telefoneOpcao2 = telefoneOpcao2;
	}

	public String getTelefoneOpcao3() {
		return telefoneOpcao3;
	}

	public void setTelefoneOpcao3(String telefoneOpcao3) {
		this.telefoneOpcao3 = telefoneOpcao3;
	}

	public String getNicho() {
		return nicho;
	}

	public void setNicho(String nicho) {
		this.nicho = nicho;
	}

	public String getPorteEmpresa() {
		return porteEmpresa;
	}

	public void setPorteEmpresa(String porteEmpresa) {
		this.porteEmpresa = porteEmpresa;
	}

	public Integer getNumeroFuncionarios() {
		return numeroFuncionarios;
	}

	public void setNumeroFuncionarios(Integer numeroFuncionarios) {
		this.numeroFuncionarios = numeroFuncionarios;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getMetodoPagamento() {
		return metodoPagamento;
	}

	public void setMetodoPagamento(String metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}
	
	
	
	
	
}