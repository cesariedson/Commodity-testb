package com.objetos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "mercadoria")
@NamedQueries({ @NamedQuery(name = "Mercadoria.trazerTudo", query = "SELECT m FROM Mercadoria m"),
		@NamedQuery(name = "Mercadoria.trazerId", query = "SELECT m FROM Mercadoria m WHERE m.codmercadoria = :codmercadoria")

})
public class Mercadoria implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codmercadoria;

	@Column(length = 60, nullable = false)
	private String nomemercadoria;

	@Column(nullable = false)
	private int quantidade;

	@Column(nullable = false)
	private double preco;

	@Column(nullable = false)
	private TipoNegocio tiponegocio;

	public Long getCodmercadoria() {
		return codmercadoria;
	}

	public void setCodmercadoria(Long codmercadoria) {
		this.codmercadoria = codmercadoria;
	}

	public String getNomemercadoria() {
		return nomemercadoria;
	}

	public void setNomemercadoria(String nomemercadoria) {
		this.nomemercadoria = nomemercadoria;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public TipoNegocio getTiponegocio() {
		return tiponegocio;
	}

	public void setTiponegocio(TipoNegocio tiponegocio) {
		this.tiponegocio = tiponegocio;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
