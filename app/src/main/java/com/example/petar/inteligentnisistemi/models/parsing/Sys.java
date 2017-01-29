package com.example.petar.inteligentnisistemi.models.parsing;

public class Sys {
	
	Integer type;
	Integer id;
	Double message;
	String country;
	Double sunrise;
	Double sunset;
	public Sys() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sys(Integer type, Integer id, Double message, String country, Double sunrise, Double sunset) {
		super();
		this.type = type;
		this.id = id;
		this.message = message;
		this.country = country;
		this.sunrise = sunrise;
		this.sunset = sunset;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getMessage() {
		return message;
	}
	public void setMessage(Double message) {
		this.message = message;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Double getSunrise() {
		return sunrise;
	}
	public void setSunrise(Double sunrise) {
		this.sunrise = sunrise;
	}
	public Double getSunset() {
		return sunset;
	}
	public void setSunset(Double sunset) {
		this.sunset = sunset;
	}
	@Override
	public String toString() {
		return "Sys [type=" + type + ", id=" + id + ", message=" + message + ", country=" + country + ", sunrise="
				+ sunrise + ", sunset=" + sunset + "]";
	}
	

}
