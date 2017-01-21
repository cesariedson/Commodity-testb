package com.testesunitarios;

import com.objetos.Mercadoria;
import com.persistencia.MercadoriaDAO;
import com.persistencia.MercadoriaDAODB;

public class Teste2 {

	public static void main(String[] args) {
		
		MercadoriaDAO mercadoriaDAO = new MercadoriaDAODB();
		
		System.out.println("Dentro tem "+mercadoriaDAO.trazerMercadorias().size()+" no banco de dados");
		for (Mercadoria merc : mercadoriaDAO.trazerMercadorias()) {
			System.out.println("Nome mercadoria: "+merc.getNomemercadoria()+" e o preco e: "+merc.getPreco()+" e quantidade: "+merc.getQuantidade());
		}
	}

}
