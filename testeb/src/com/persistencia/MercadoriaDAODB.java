package com.persistencia;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.objetos.Mercadoria;

public class MercadoriaDAODB implements MercadoriaDAO {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("JSFCrudPU");
	private EntityManager em = emf.createEntityManager();

	@Override
	public boolean inserir(Mercadoria mercadoria) {

		try {
			em.getTransaction().begin();
			em.persist(mercadoria);
			em.getTransaction().commit();

			return true;

		} catch (Exception e) {
			em.getTransaction().rollback();

			return false;
		}

	}

	@Override
	public boolean atualizar(Mercadoria mercadoria) {
		try {
			em.getTransaction().begin();
			em.merge(mercadoria);
			em.getTransaction().commit();

			return true;
		} catch (Exception e) {
			em.getTransaction().rollback();

			return false;
		}

	}

	@Override
	public boolean excluir(Mercadoria mercadoria) {
		try {
			em.getTransaction().begin();
			em.remove(em.getReference(Mercadoria.class, mercadoria.getCodmercadoria()));
			em.getTransaction().commit();

			return true;
		} catch (Exception e) {
			em.getTransaction().rollback();

			return false;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Mercadoria> trazerMercadorias() {

		try {
			Query query = em.createNamedQuery("Mercadoria.trazerTudo");

			return query.getResultList();

		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Mercadoria trazerMercadoria(Mercadoria mercadoria) {
		try {
			Query query = em.createNamedQuery("Mercadoria.trazerId");
			query.setParameter("codmercadoria", mercadoria.getCodmercadoria());

			return (Mercadoria) query.getSingleResult();
		} catch (Exception e) {

			return null;
		}

	}

}
