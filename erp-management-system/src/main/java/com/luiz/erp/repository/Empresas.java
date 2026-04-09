package com.luiz.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.luiz.erp.model.Empresa;

public class Empresas implements Serializable {
	
	private static final long serialVersionUID = 1L;

	
	//Buscar , guardar remover operações para o banco de dados 
	private EntityManager manager;
	
	public Empresas() {
		
	}
	
	public Empresas (EntityManager manager) {
		this.manager = manager;
	}
	
	//Buscar por id usando find 
	public Empresa  porId(Long id) {
		return manager.find(Empresa.class,id );
	}
	
	//Pesquisa por empresa por nome, lista de empresa ,query
	//Consulta de String passada por parametro 
	public List<Empresa> pesquisar(String nome) {
		String jpql="from Empresa where nomeFantasia like : nomeFantasia";
		
		TypedQuery<Empresa> query = manager.createQuery(jpql, Empresa.class);
		query.setParameter("nomeFantasia", nome +"%");
		return query.getResultList();
		
	}
	
	//Guardar empresa 
	public Empresa guardar (Empresa empresa) {
		return manager.merge(empresa);
	}
	
	public void remover (Empresa empresa) {
		empresa = porId(empresa.getId());
		manager.remove(empresa);
	}
	
	

}
