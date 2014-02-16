package de.tgehring.coins.server.entities.filter;

import java.util.LinkedList;
import java.util.List;

import de.tgehring.coins.server.entities.Coin;

public class CoinValueFilter implements CoinFilterInterface {
	
	private double value;
	
	public CoinValueFilter(double value) {
		this.value = value;
	}
	
	@Override
	public List<Coin> filter(List<Coin> coins) {
		List<Coin> resultList = new LinkedList<Coin>();
		for (Coin coin: coins) {
			if (coin.getValue() == value) {
				resultList.add(coin);
			}
		}
		
		return resultList;
	}
}
