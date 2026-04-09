package com.luiz.erp.injecaodependencias;

public class Main {
	public static void main(String[] args) {
		Pedidos pedidos = new Pedidos();
		
//		RelatorioService relatorioService = new RelatorioService(pedidos);
		RelatorioService relatorioService = new RelatorioService();
//		relatorioService.setPedidos(pedidos);
		
		//Injeção com CDI 
		
	}
}
