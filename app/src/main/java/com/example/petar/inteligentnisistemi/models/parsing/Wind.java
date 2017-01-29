package com.example.petar.inteligentnisistemi.models.parsing;


public class Wind {

	Integer speed;

	public Wind() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Wind(Integer speed) {
		super();
		this.speed = speed;
	}

	public Integer getSpeed() {
		return speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
	}

	@Override
	public String toString() {
		return "Wind [speed=" + speed + "]";
	}
	
}
