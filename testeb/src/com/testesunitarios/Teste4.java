package com.testesunitarios;

import com.objetos.Mercadoria;
import com.persistencia.MercadoriaDAO;
import com.persistencia.MercadoriaDAODB;

public class Teste4 {

	public static void main(String[] args) {

		MercadoriaDAO mercadoriaDAO = new MercadoriaDAODB();
		Mercadoria mercadoria = new Mercadoria();
		mercadoria.setCodmercadoria(1L);
		
		System.out.println("A mercadoria é :"+mercadoriaDAO.trazerMercadoria(mercadoria).getNomemercadoria());
		 
	
	}

}
