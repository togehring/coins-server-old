package de.tgehring.coins.server.entities.dao;

import java.util.List;

import javax.persistence.EntityManager;

public class GenericDao<T> {
	
	private EntityManager em;
	private Class<T> type;
	
	public GenericDao(EntityManager em, Class<T> type) {
		this.em = em;
		this.type = type;
	}
	
	public void create(T entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}
	
	public T findOne(long id) {
		em.getTransaction().begin();
		T entity = em.find(type, id);
		System.out.println(type);
		em.getTransaction().commit();
		return entity;
	}
	
	public List<T> findAll() {
		em.getTransaction().begin();
		List<T> entities = em.createNamedQuery(type.getSimpleName() + ".findAll").getResultList();
		em.getTransaction().commit();
		return entities;
	}
	
	public void update(T entity) {
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
	}
	
	public void delete(long id) {
		em.getTransaction().begin();
		T entity = em.find(type, id);
		em.remove(entity);
		em.getTransaction().commit();
	}
	
	public void delete(T entity) {
		em.getTransaction().begin();
		em.remove(entity);
		em.getTransaction().commit();
	}
}
