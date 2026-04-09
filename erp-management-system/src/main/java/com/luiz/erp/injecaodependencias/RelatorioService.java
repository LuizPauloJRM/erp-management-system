package com.luiz.erp.injecaodependencias;

import java.math.BigDecimal;

public class RelatorioService {
	
	//Dependencia de Relatorio Service 
	//Declarando a propriedade
	private Pedidos pedidos = new Pedidos();	
	
	public RelatorioService(Pedidos pedidos) {
		this.pedidos = pedidos;
	}
	
	//Injeção atraves do construtor 
	public RelatorioService() {
	
	}

	public BigDecimal totalPedidosMesAtual() {
		return pedidos.totalPedidosMesAtual();
	}
	
	//Injeção 
	public void setPedidos(Pedidos pedidos) {
		this.pedidos = pedidos;
	}
}
