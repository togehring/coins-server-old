package de.tgehring.coins.server.entities.filter;

import java.util.LinkedList;
import java.util.List;

import de.tgehring.coins.server.entities.Coin;

public class CoinYearFilter implements CoinFilterInterface {
	
	private int year;
	
	public CoinYearFilter(int year) {
		this.year = year;
	}

	@Override
	public List<Coin> filter(List<Coin> coins) {
		List<Coin> resultList = new LinkedList<Coin>();
		for (Coin coin: coins) {
			if (coin.getYear() == year) {
				resultList.add(coin);
			}
		}
		
		return resultList;
	}
}
