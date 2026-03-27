package com.luiz.erp.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.luiz.erp.model.Empresa;
import com.luiz.erp.model.Servico;
//Classe teste de pesquisa 
public class CamadaPersistencia {
	
	public static void main(String[] args) {		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("erpmanagement");
		
		//Instancia de EntityManager do JPA 
		EntityManager em = emf.createEntityManager();
		
		
		//Iniciar transação , insert no banco de dados 
		em.getTransaction().begin();
		
		//Declarando os repositórios
		Servicos servicos = new Servicos(em);
		Empresas empresas = new Empresas(em);
		
		//Buscando as informações do banco de dados 
		List<Servico> listaDeServicos = servicos.pesquisar("");
		List<Empresa> listaDeEmpresas = empresas.pesquisar("");
		
		//Quantidade de empresas 
		System.out.println(listaDeEmpresas);
		
		//Criando uma empresa e adicionando os dados dela 
		Empresa empresa = new Empresa();
		
		empresa.setNomeFantasia("João da Silva");
		empresa.setCnpj("41.952.519/0001-57");
		empresa.setRazaoSocial("Luiz Paulo 41952519000157");
//		empresa.setTipoEmpresa(TipoEmpresa.MEI);
		empresa.setDataFundacao(new Date());
		empresa.setServicos(listaDeServicos.get(0));
		
		//Salvando a empresa
		empresas.guardar(empresa);
		
		//Encerrando a transação 
		em.getTransaction().commit();
		
		//Verificando se a inserção funcionou
		List<Empresa> listaDeEmpresas2 = empresas.pesquisar("");
		System.out.println(listaDeEmpresas2);
		
		
		em.close();
		emf.close();
	}

}