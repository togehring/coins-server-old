package de.tgehring.coins.server.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import de.tgehring.coins.server.entities.Coin;
import de.tgehring.coins.server.entities.Country;
import de.tgehring.coins.server.entities.dao.GenericDao;
import de.tgehring.coins.server.entities.filter.CoinFilter;

public class CrudService {
	
	private static CrudService instance = null;
	private static final String PERSISTENCE_UNIT_NAME = "Coins";
	private static EntityManagerFactory factory;
	private EntityManager em;
	
	private CrudService() {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em = factory.createEntityManager();
	}
	
	public static CrudService getInstance() {
		if(instance == null) {
			instance = new CrudService();
			
		}
		return instance;
	}
	
	public void addCoin(Coin coin) {
		new GenericDao<Coin>(em, Coin.class).create(coin);
	}
	
	public void editCoin(Coin coin) {
		new GenericDao<Coin>(em, Coin.class).update(coin);
	}
	
	public void deleteCoin(long id) {
		new GenericDao<Coin>(em, Coin.class).delete(id);
	}
	
	public Coin getCoin(long id) {
		return new GenericDao<Coin>(em, Coin.class).findOne(id);
	}
	
	public List<Coin> getAllCoins(CoinFilter filterChain) {
		List<Coin> coins = new GenericDao<Coin>(em, Coin.class).findAll(); 
		coins = filterChain.filter(coins);
		
		return coins;
	}
	
	public void addCountry(Country country) {
		new GenericDao<Country>(em, Country.class).create(country);
	}
	
	public void editCountry(Country country) {
		new GenericDao<Country>(em, Country.class).update(country);
	}
	
	public void deleteCountry(long id) {
		new GenericDao<Country>(em, Country.class).delete(id);
	}
	
	public Country getCountry(long id) {
		return new GenericDao<Country>(em, Country.class).findOne(id);
	}
	
	public List<Country> getAllCountries() {
		return new GenericDao<Country>(em, Country.class).findAll();
	}
}
