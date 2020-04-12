package br.unipe.luis.web.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory em = Persistence.createEntityManagerFactory("gerenciador-aula");


	public static EntityManager getEntityManager() {
		return em.createEntityManager();
	}


}
