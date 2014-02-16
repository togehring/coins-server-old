package de.tgehring.coins.server.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@NamedQuery(name="Coin.findAll", query="SELECT c FROM Coin c")
@XmlRootElement
public class Coin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Country country;
	
	private double value;
	private int year;
	private char letter;
	private boolean commemorative;
	private String description;
	
	public Coin() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public char getLetter() {
		return letter;
	}

	public void setLetter(char letter) {
		this.letter = letter;
	}

	public boolean isCommemorative() {
		return commemorative;
	}

	public void setCommemorative(boolean commemorative) {
		this.commemorative = commemorative;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.country + "[" + this.value + "] ");
		sb.append("(" + this.year + ") ");
		sb.append(this.letter);
		if (this.commemorative) {
			sb.append("Sondermünze");
		}
		
		return sb.toString();
	}
}
