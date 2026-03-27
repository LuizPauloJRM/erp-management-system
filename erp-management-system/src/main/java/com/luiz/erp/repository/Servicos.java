package com.luiz.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.luiz.erp.model.Servico;

public class Servicos implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;
	
	public Servicos() {
		
	}
	
	//Construtor
	public Servicos(EntityManager manager) {
		this.manager  = manager;
	}
	
	public List<Servico> pesquisar (String descricao){
		//Classe Util que são usadas 
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		
		
		CriteriaQuery<Servico> criteriaQuery = criteriaBuilder.createQuery(Servico.class);
		Root<Servico> root = criteriaQuery.from(Servico.class);
		criteriaQuery.select(root);
		criteriaQuery.where(criteriaBuilder.like(root.get("descricao"),descricao +"%"));
		
		TypedQuery<Servico> query = manager.createQuery(criteriaQuery);
		
		return query.getResultList();
	}
}
