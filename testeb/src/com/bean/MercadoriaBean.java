package com.bean;

import java.util.Collection;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.objetos.Mercadoria;
import com.objetos.TipoNegocio;
import com.persistencia.MercadoriaDAO;
import com.persistencia.MercadoriaDAODB;

@RequestScoped
@ManagedBean(name="mercadoriabean")
public class MercadoriaBean {
	private Mercadoria mercadoria = new Mercadoria();
	private Collection<Mercadoria> mercadorias;
	private TipoNegocio tiponegocio;
	private TipoNegocio[] tiponegocios;
	
	//Metodos de manipulação de pagina
	public String editar(){
		return "/paginas/edicao";
	}
	
	public String salvar(){
		if(this.mercadoria.getCodmercadoria()== null){
			return inserir();
		}else{
			return atualizar();
		}
		
	}
	public void mensagens(String mensagem){
		FacesContext fc = FacesContext.getCurrentInstance();
		FacesMessage fm = new FacesMessage("Ocorreu um erro ao "+mensagem+" a mercadoria.");
		fm.setSeverity(FacesMessage.SEVERITY_ERROR);
		fc.addMessage(null, fm);
	}
	
	public String inserir(){
		MercadoriaDAO mercadoriaDAO = new MercadoriaDAODB();
		
		if(mercadoriaDAO.inserir(this.mercadoria)==false){
			mensagens("inserir");
			
			return"paginas/edicao";
		}else{
			
			return "/paginas/mercadorias";
		}
		
		
	}
	private String atualizar(){
		MercadoriaDAO mercadoriaDAO = new MercadoriaDAODB();
		if(mercadoriaDAO.atualizar(this.mercadoria)==false){
			mensagens("atualizar");
			
			return"paginas/edicao";
		}else{
			
			return "/paginas/mercadorias";
		}
	}
	public String excluir(){
		MercadoriaDAO mercadoriaDAO = new MercadoriaDAODB();
		if(mercadoriaDAO.excluir(this.mercadoria)==false){
			mensagens("excluir");
		}
		
		return null;
	}
	public String trazerId(){
		MercadoriaDAO mercadoriaDAO = new MercadoriaDAODB();
		mercadoriaDAO.trazerMercadoria(this.mercadoria);
		
		return null;
	}
	
	//Getter and Setters
	public Mercadoria getMercadoria() {
		return mercadoria;
	}
	
	public TipoNegocio getTiponegocio() {
		return tiponegocio;
	}

	public void setTiponegocio(TipoNegocio tiponegocio) {
		this.tiponegocio = tiponegocio;
	}

	public TipoNegocio[] getTiponegocios() {
		this.tiponegocios = TipoNegocio.values();
		
		return tiponegocios;
	}

	public void setTiponegocios(TipoNegocio[] tiponegocios) {
		this.tiponegocios = tiponegocios;
	}

	public void setMercadoria(Mercadoria mercadoria) {
		this.mercadoria = mercadoria;
	}
	public Collection<Mercadoria> getMercadorias() {
		MercadoriaDAO mercadoriaDAO = new MercadoriaDAODB();
		this.mercadorias = mercadoriaDAO.trazerMercadorias();
		
		return this.mercadorias;
	}
	public void setMercadorias(Collection<Mercadoria> mercadorias) {
		this.mercadorias = mercadorias;
	}

	public TipoNegocio[] getTipoNegocios() {
		this.tiponegocios = TipoNegocio.values();
		
		return this.tiponegocios;
	}

	public void setTipoNegocios(TipoNegocio[] tipoNegocios) {
		this.tiponegocios = tipoNegocios;
	}
	
}
