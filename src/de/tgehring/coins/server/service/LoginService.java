package de.tgehring.coins.server.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import de.tgehring.coins.server.entities.User;
import de.tgehring.coins.server.entities.dao.GenericDao;

public class LoginService {
	
	private static LoginService instance = null;
	private static final String PERSISTENCE_UNIT_NAME = "Coins";
	private static EntityManagerFactory factory;
	private EntityManager em;
	
	private LoginService() {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em = factory.createEntityManager();
	}
	
	public static LoginService getInstance() {
		if(instance == null) {
			instance = new LoginService();
			
		}
		return instance;
	}
	
	public boolean login(String name, String password) {
		List<User> validUsers = new GenericDao<User>(em, User.class).findAll();
		for(User user: validUsers) {
			if (user.getName().equals(name) && user.getPassword().equals(password)) {
				return true;
			}
		}
		
		return false;
	}
}
