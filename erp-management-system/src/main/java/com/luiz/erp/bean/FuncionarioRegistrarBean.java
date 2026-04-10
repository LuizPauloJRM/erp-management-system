package com.luiz.erp.bean;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Named;


//Criando um bean , implementação serializable 
//Bean -> Controle gerenciavel
//Responsavel por instanciar a classe e atributos 

@Named
public class FuncionarioRegistrarBean implements Serializable {
	private String nmEmpregado = "Luiz";
	private String sobrenome = "Paulo";
	private Date dtNascimento;
	//Atributo de modelo de negocio 
	//testando  
	
	
	
	//Get e Set
	public String getNmEmpregado() {
		return nmEmpregado;
	}
	public void setNmEmpregado(String nmEmpregado) {
		this.nmEmpregado = nmEmpregado;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public Date getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	
	
	
	
	
}
