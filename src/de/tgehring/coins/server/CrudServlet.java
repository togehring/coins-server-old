package de.tgehring.coins.server;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBElement;

import de.tgehring.coins.server.service.CrudService;
import de.tgehring.coins.server.entities.Coin;
import de.tgehring.coins.server.entities.Country;
import de.tgehring.coins.server.entities.filter.CoinCountryFilter;
import de.tgehring.coins.server.entities.filter.CoinFilter;
import de.tgehring.coins.server.entities.filter.CoinValueFilter;
import de.tgehring.coins.server.entities.filter.CoinYearFilter;

@Path("/crud")
public class CrudServlet {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/coin")
	public Response addCoin(JAXBElement<Coin> coin) {
		CrudService.getInstance().addCoin(coin.getValue());
		String result = "Coin saved : " + coin.getValue();
		return Response.status(201).entity(result).build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/coin")
	public Response editCoin(JAXBElement<Coin> coin) {
		CrudService.getInstance().editCoin(coin.getValue());
		String result = "Coin edited : " + coin.getValue();
		return Response.status(201).entity(result).build();
	}
	
	@DELETE
	@Path("/coin/{id}")
	public Response deleteCoin(@PathParam("id") long id) {
		CrudService.getInstance().deleteCoin(id);
		String result = "Coin deleted : ID=" + id;
		return Response.status(201).entity(result).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/coin/{id}")
	public Coin getCoin(@PathParam("id") long id) {
		return CrudService.getInstance().getCoin(id);
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/coin/{id}")
	public String getCoinHtml() {
		return "";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/coins")
	public List<Coin> getAllCoins(
			@DefaultValue("") @QueryParam("countryName") String countryName,
			@DefaultValue("0") @QueryParam("coinValue") double coinValue,
		    @DefaultValue("0") @QueryParam("coinYear") int coinYear) {
		CoinFilter filterChain = new CoinFilter();
		if (countryName.length() > 0) {
			CoinCountryFilter countryFilter = new CoinCountryFilter(countryName);
			filterChain.addFilter(countryFilter);
		}
		if (coinValue != 0) {
			CoinValueFilter valueFilter = new CoinValueFilter(coinValue);
			filterChain.addFilter(valueFilter);
		}
		if (coinYear != 0) {
			CoinYearFilter yearFilter = new CoinYearFilter(coinYear);
			filterChain.addFilter(yearFilter);
		}
		
		return CrudService.getInstance().getAllCoins(filterChain);
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/coins")
	public String getAllCoinsHtml() {
		return "";
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/country")
	public Response addCountry(JAXBElement<Country> country) {
		CrudService.getInstance().addCountry(country.getValue());
		String result = "Country saved : " + country.getValue();
		return Response.status(201).entity(result).build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/country")
	public Response editCountry(JAXBElement<Country> country) {
		CrudService.getInstance().editCountry(country.getValue());
		String result = "Country edited : " + country.getValue();
		return Response.status(201).entity(result).build();
	}
	
	@DELETE
	@Path("/country/{id}")
	public Response deleteCountry(@PathParam("id") long id) {
		CrudService.getInstance().deleteCountry(id);
		String result = "Country deleted : ID=" + id;
		return Response.status(201).entity(result).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/country/{id}")
	public Country getCountry(@PathParam("id") long id) {
		return CrudService.getInstance().getCountry(id);
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/country/{id}")
	public String getCountryHtml() {
		return "";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/countries")
	public List<Country> getAllCountries() {
		return CrudService.getInstance().getAllCountries();
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/countries")
	public String getAllCountriesHtml() {
		return "";
	}
}
