package com.example.petar.inteligentnisistemi.models.parsing;

public class CountryNames {
	
	public String countryName;
	
	public CountryNames() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public CountryNames(String countryName) {
		super();
		this.countryName = countryName;
	}


	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}


	@Override
	public String toString() {
		return "CountryNames [countryName=" + countryName + "]";
	}
	
}
