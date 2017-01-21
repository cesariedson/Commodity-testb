package com.testesunitarios;

import com.objetos.Mercadoria;
import com.persistencia.MercadoriaDAO;
import com.persistencia.MercadoriaDAODB;

public class Teste5 {

	public static void main(String[] args) {

		Mercadoria mercadoria = new Mercadoria();
		mercadoria.setCodmercadoria(1L);
		
		MercadoriaDAO mercadoriaDAO = new MercadoriaDAODB();
		mercadoriaDAO.excluir(mercadoria);

	}

}
