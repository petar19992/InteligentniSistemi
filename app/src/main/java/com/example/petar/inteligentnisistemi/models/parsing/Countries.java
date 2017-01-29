package com.example.petar.inteligentnisistemi.models.parsing;


import java.util.List;

public class Countries {
	
	List<CountryNames> countryNames;

	public Countries() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Countries(List<CountryNames> countryNames) {
		super();
		this.countryNames = countryNames;
	}

	public List<CountryNames> getCountryNames() {
		return countryNames;
	}

	public void setCountryNames(List<CountryNames> countryNames) {
		this.countryNames = countryNames;
	}

	@Override
	public String toString() {
		return "Countries [countryNames=" + countryNames + "]";
	}
}
