package de.tgehring.coins.server.entities.filter;

import java.util.LinkedList;
import java.util.List;

import de.tgehring.coins.server.entities.Coin;

public class CoinCountryFilter implements CoinFilterInterface {

	private String countryName;
	
	public CoinCountryFilter(String countryName) {
		this.countryName = countryName;
	}
	@Override
	public List<Coin> filter(List<Coin> coins) {
		List<Coin> resultList = new LinkedList<Coin>();
		for (Coin coin: coins) {
			if (coin.getCountry().getName().equals(countryName)) {
				resultList.add(coin);
			}
		}
		
		return resultList;
	}
}
