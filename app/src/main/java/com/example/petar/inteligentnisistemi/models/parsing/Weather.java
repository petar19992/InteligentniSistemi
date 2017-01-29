package com.example.petar.inteligentnisistemi.models.parsing;


public class Weather {
	
	Integer id;
	String main;
	String description;
	String icon;
	public Weather() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Weather(Integer id, String main, String description, String icon) {
		super();
		this.id = id;
		this.main = main;
		this.description = description;
		this.icon = icon;
	}

	public Weather(String main, String description, String icon) {
		super();
		this.main = main;
		this.description = description;
		this.icon = icon;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMain() {
		return main;
	}
	public void setMain(String main) {
		this.main = main;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Override
	public String toString() {
		return "Weather [id=" + id + ", main=" + main + ", description=" + description + ", icon=" + icon + "]";
	}
	
}
