package com.example.petar.inteligentnisistemi.models.parsing;


public class Main {

	Double temp;
	Integer pressure;
	Integer humidity;
	Integer temp_min;
	Integer temp_max;
	public Main() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Main(Double temp, Integer pressure, Integer humidity, Integer temp_min, Integer temp_max) {
		super();
		this.temp = temp;
		this.pressure = pressure;
		this.humidity = humidity;
		this.temp_min = temp_min;
		this.temp_max = temp_max;
	}
	public Double getTemp() {
		return temp;
	}
	public void setTemp(Double temp) {
		this.temp = temp;
	}
	public Integer getPressure() {
		return pressure;
	}
	public void setPressure(Integer pressure) {
		this.pressure = pressure;
	}
	public Integer getHumidity() {
		return humidity;
	}
	public void setHumidity(Integer humidity) {
		this.humidity = humidity;
	}
	public Integer getTemp_min() {
		return temp_min;
	}
	public void setTemp_min(Integer temp_min) {
		this.temp_min = temp_min;
	}
	public Integer getTemp_max() {
		return temp_max;
	}
	public void setTemp_max(Integer temp_max) {
		this.temp_max = temp_max;
	}
	@Override
	public String toString() {
		return "Main [temp=" + temp + ", pressure=" + pressure + ", humidity=" + humidity + ", temp_min=" + temp_min
				+ ", temp_max=" + temp_max + "]";
	}
	
	
}
