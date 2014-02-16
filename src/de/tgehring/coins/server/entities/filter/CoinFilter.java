package de.tgehring.coins.server.entities.filter;

import java.util.LinkedList;
import java.util.List;

import de.tgehring.coins.server.entities.Coin;

public class CoinFilter implements CoinFilterInterface {
	
	private List<CoinFilterInterface> filterChain;
	
	public CoinFilter() {
		this.filterChain = new LinkedList<CoinFilterInterface>();
	}
	
	public CoinFilter(List<CoinFilterInterface> filterChain) {
		this.filterChain = filterChain;
	}
	
	public void addFilter(CoinFilterInterface filter) {
		this.filterChain.add(filter);
	}

	@Override
	public List<Coin> filter(List<Coin> coins) {
		if (filterChain.size() == 0) {
			return coins;
		}
		
		for(CoinFilterInterface filter: filterChain) {
			if (coins.size() == 0) {
				return coins;
			}
			coins = filter.filter(coins);
		}
		
		return coins;
	}
}
