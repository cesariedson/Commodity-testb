package com.persistencia;

import java.util.Collection;

import com.objetos.Mercadoria;

public interface MercadoriaDAO {
	public boolean inserir(Mercadoria mercadoria);
	public boolean atualizar(Mercadoria mercadoria);
	public boolean excluir(Mercadoria mercadoria);
	public Mercadoria trazerMercadoria(Mercadoria mercadoria);
	public Collection<Mercadoria> trazerMercadorias();
}
