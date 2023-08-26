package com.sebastianwrobel.api.domain.openweather;

public class Sys {
	private Long type;
	private Long id;
	private String message;
	private String country;
	private Long sunrise;
	private Long sunset;
	
	public Long getType() {
		return type;
	}
	public void setType(Long type) {
		this.type = type;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Long getSunrise() {
		return sunrise;
	}
	public void setSunrise(Long sunrise) {
		this.sunrise = sunrise;
	}
	public Long getSunset() {
		return sunset;
	}
	public void setSunset(Long sunset) {
		this.sunset = sunset;
	}
	@Override
	public String toString() {
		return "Sys [type=" + type + ", id=" + id + ", message=" + message + ", country=" + country + ", sunrise="
				+ sunrise + ", sunset=" + sunset + "]";
	}
	
	
}
