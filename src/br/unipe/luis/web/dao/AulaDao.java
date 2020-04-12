package br.unipe.luis.web.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.unipe.luis.web.model.Aula;
import br.unipe.luis.web.util.JPAUtil;


public class AulaDao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	EntityManager em;

	public List<Aula> buscarTodos() {
		List<Aula> aulas = new ArrayList<Aula>();
		em = JPAUtil.getEntityManager();
		String jpql = "FROM Aula a";
		TypedQuery<Aula> query = em.createQuery(jpql, Aula.class);
		aulas = query.getResultList();
		return aulas;
	}

	public void inserir(Aula aula) {
		em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(aula);
		em.getTransaction().commit();
		em.close();

	}

	public void alterar(Aula aula) {
		em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(aula);
		em.getTransaction().commit();
		em.close();

	}

	public Aula buscarPorId(int id) {
		em = JPAUtil.getEntityManager();
		Aula a = em.find(Aula.class, id);
		em.close();
		return a;
	}

	public void remover(int id) {
		em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		Aula a = em.find(Aula.class, id);
		em.remove(a);
		em.getTransaction().commit();
		em.close();
	}

	

}
