package br.unipe.luis.web.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.unipe.luis.web.model.Tarefa;
import br.unipe.luis.web.util.JPAUtil;

public class TarefaDao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	EntityManager em;

	public List<Tarefa> buscarTodos() {
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		em = JPAUtil.getEntityManager();
		String jpql = "FROM Tarefa t";
		TypedQuery<Tarefa> query = em.createQuery(jpql, Tarefa.class);
		tarefas = query.getResultList();
		return tarefas;
	}

	public void inserir(Tarefa tarefa) {
		em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(tarefa);
		em.getTransaction().commit();
		em.close();

	}

	public void alterar(Tarefa tarefa) {
		em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(tarefa);
		em.getTransaction().commit();
		em.close();

	}

	public Tarefa buscarPorId(int id) {
		em = JPAUtil.getEntityManager();
		Tarefa t = em.find(Tarefa.class, id);
		em.close();
		return t;
	}

	public void remover(int id) {
		em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		Tarefa t = em.find(Tarefa.class, id);
		em.remove(t);
		em.getTransaction().commit();
		em.close();
	}

	
}
