package com.testesunitarios;

import com.objetos.Mercadoria;
import com.objetos.TipoNegocio;
import com.persistencia.MercadoriaDAO;
import com.persistencia.MercadoriaDAODB;

public class Teste1 {

	public static void main(String[] args) {

		// Criamos um objeto simples
		Mercadoria mercadoria = new Mercadoria();
		mercadoria.setNomemercadoria("Tablet");
		mercadoria.setPreco(750.00);
		mercadoria.setQuantidade(1);
		mercadoria.setTiponegocio(TipoNegocio.VENDA);

		// Realizamos a persistencia do objeto atravéz da classe DAO.
		MercadoriaDAO mercadoriaDAO = new MercadoriaDAODB();
		if (mercadoriaDAO.inserir(mercadoria)) {
			System.out.println("Mercadoria inserida com sucesso");
		}

		// Criamos um objeto simples
		Mercadoria mercadoria2 = new Mercadoria();
		mercadoria2.setNomemercadoria("NoteBook");
		mercadoria2.setPreco(1750.00);
		mercadoria2.setQuantidade(2);
		mercadoria2.setTiponegocio(TipoNegocio.COMPRA);

		// Realizamos a persistencia do objeto atravéz da classe DAO.
		if (mercadoriaDAO.inserir(mercadoria2)) {
			System.out.println("Mercadoria inserida com sucesso");
		}
	}

}
