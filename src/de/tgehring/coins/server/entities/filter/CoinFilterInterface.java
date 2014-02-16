package de.tgehring.coins.server.entities.filter;

import java.util.List;

import de.tgehring.coins.server.entities.Coin;

public interface CoinFilterInterface {
	
	public List<Coin> filter(List<Coin> coins);
}
