package com.testesunitarios;

import com.objetos.Mercadoria;
import com.objetos.TipoNegocio;
import com.persistencia.MercadoriaDAO;
import com.persistencia.MercadoriaDAODB;

public class Teste3 {

	public static void main(String[] args) {
		
		Mercadoria mercadoria = new Mercadoria();
		mercadoria.setCodmercadoria(1L);
		mercadoria.setNomemercadoria("Outro");
		mercadoria.setTiponegocio(TipoNegocio.VENDA);
		mercadoria.setQuantidade(5);
		
		MercadoriaDAO mercadoriaDAO = new MercadoriaDAODB();
		if(mercadoriaDAO.atualizar(mercadoria)){
			System.out.println("Atualizado com sucesso");
		}

	}

}
