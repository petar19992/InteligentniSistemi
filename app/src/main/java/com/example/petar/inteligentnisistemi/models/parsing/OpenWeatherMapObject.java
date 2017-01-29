package com.example.petar.inteligentnisistemi.models.parsing;


import java.util.List;

public class OpenWeatherMapObject {

	Coord coord;
	List<Weather> weather;
	String base;
	Main main;
	Integer visibility;
	Wind wind;
	Clouds clouds;
	Double dt;
	Sys sys;
	Double id;
	String name;
	Integer cod;
	public OpenWeatherMapObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public OpenWeatherMapObject(Coord coord, List<Weather> weather, String base, Main main, Integer visibility,
                                Wind wind, Clouds clouds, Double dt, Sys sys, Double id, String name, Integer cod) {
		super();
		this.coord = coord;
		this.weather = weather;
		this.base = base;
		this.main = main;
		this.visibility = visibility;
		this.wind = wind;
		this.clouds = clouds;
		this.dt = dt;
		this.sys = sys;
		this.id = id;
		this.name = name;
		this.cod = cod;
	}

	public Coord getCoord() {
		return coord;
	}
	public void setCoord(Coord coord) {
		this.coord = coord;
	}
	public List<Weather> getWeather() {
		return weather;
	}
	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}

	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public Main getMain() {
		return main;
	}
	public void setMain(Main main) {
		this.main = main;
	}
	public Integer getVisibility() {
		return visibility;
	}
	public void setVisibility(Integer visibility) {
		this.visibility = visibility;
	}
	public Wind getWind() {
		return wind;
	}
	public void setWind(Wind wind) {
		this.wind = wind;
	}
	public Clouds getClouds() {
		return clouds;
	}
	public void setClouds(Clouds clouds) {
		this.clouds = clouds;
	}
	public Double getDt() {
		return dt;
	}
	public void setDt(Double dt) {
		this.dt = dt;
	}
	public Sys getSys() {
		return sys;
	}
	public void setSys(Sys sys) {
		this.sys = sys;
	}
	public Double getId() {
		return id;
	}
	public void setId(Double id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCod() {
		return cod;
	}
	public void setCod(Integer cod) {
		this.cod = cod;
	}
	@Override
	public String toString() {
		return "OpenWeatherMapObject [coord=" + coord + ", weather=" + weather + ", base=" + base + ", main=" + main
				+ ", visibility=" + visibility + ", wind=" + wind + ", clouds=" + clouds + ", dt=" + dt + ", sys=" + sys
				+ ", id=" + id + ", name=" + name + ", cod=" + cod + "]";
	}
	
	
}
