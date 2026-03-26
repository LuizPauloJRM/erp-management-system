package com.luiz.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class Servicos implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;
	
	public Servicos() {
		
	}
	
	public Servicos(EntityManager manager) {
		this.manager  = manager;
	}
	
	public List<Servicos> pesquisar (String descricao){
		//Classe Util que são usadas 
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		
		
		CriteriaQuery<Servicos> criteriaQuery = criteriaBuilder.createQuery(Servicos.class);
		Root<Servicos> root = criteriaQuery.from(Servicos.class);
		criteriaQuery.select(root);
		criteriaQuery.where(criteriaBuilder.like(root.get("descricao"),descricao +"%"));
		
		TypedQuery<Servicos> query = manager.createQuery(criteriaQuery);
		
		return query.getResultList();
	}
}
