/**
 * 
 */
package com.buenmaestro.projectjpa.dao.impl;

import java.util.List;

import com.buenmaestro.projectjpa.dao.DisqueraDAO;
import com.buenmaestro.projectjpa.entity.Disquera;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * @author heber Clase que implementa las transacciones para la tabla Disquera
 */
public class DisqueraDAOImpl implements DisqueraDAO {

	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("persistenceBM");

	@Override
	public void guardar(Disquera disquera) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.persist(disquera);
			et.commit();

		} catch (Exception e) {
			if (et != null) {
				et.rollback();
			}
			e.printStackTrace();
		} finally {

			em.close();
		}

	}

	//Merge se usa para cambiar un valor de un objeto que se maneja como entidad de JPA hacia mi gestor de BD
	@Override
	public void actualizar(Disquera disquera) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.merge(disquera);
			et.commit();

		} catch (Exception e) {
			if (et != null) {
				et.rollback();
			}
			e.printStackTrace();
		} finally {

			em.close();
		}

	}

	@Override
	public void eliminar(long id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		Disquera disqueraConsultada = em.find(Disquera.class, id);

		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.remove(disqueraConsultada);
			et.commit();

		} catch (Exception e) {
			if (et != null) {
				et.rollback();
			}
			e.printStackTrace();
		} finally {

			em.close();
		}

	}

	@Override
	public List<Disquera> consultar() {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		//Bajo sentencias JPQL
		TypedQuery<Disquera> queryDisquera =  (TypedQuery<Disquera>) em.createQuery("FROM Disquera ORDER BY descripcion");
		
		return queryDisquera.getResultList();
	}

	@Override
	public Disquera consultarById(Long id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		Disquera disqueraConsultado = em.find(Disquera.class, id);
		if (disqueraConsultado == null) {
			throw new EntityNotFoundException("La disquera con id" + id + "no se encontró");

		}
		return disqueraConsultado;
	}

}
