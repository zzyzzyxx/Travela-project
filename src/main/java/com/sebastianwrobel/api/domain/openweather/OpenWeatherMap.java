package com.sebastianwrobel.api.domain.openweather;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherMap {
	private Coord coord;
	private Weather[] weather;
	private String base;
	private Main main;
	private Integer visibility;
	private Wind wind;
	private Rain rain;
	private Clouds clouds;
	private Snow snow;
	private Long dt;
	private Sys sys;
	private Long timezone;
	private Long id;
	private String name;
	private Long cod;
	
	
	public Coord getCoord() {
		return coord;
	}
	public void setCoord(Coord coord) {
		this.coord = coord;
	}
	public Weather[] getWeather() {
		return weather;
	}
	public void setWeather(Weather[] weather) {
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
	public Rain getRain() {
		return rain;
	}
	public void setRain(Rain rain) {
		this.rain = rain;
	}
	public Clouds getClouds() {
		return clouds;
	}
	public void setClouds(Clouds clouds) {
		this.clouds = clouds;
	}
	public Snow getSnow() {
		return snow;
	}
	public void setSnow(Snow snow) {
		this.snow = snow;
	}
	public Long getDt() {
		return dt;
	}
	public void setDt(Long dt) {
		this.dt = dt;
	}
	public Sys getSys() {
		return sys;
	}
	public void setSys(Sys sys) {
		this.sys = sys;
	}
	public Long getTimezone() {
		return timezone;
	}
	public void setTimezone(Long timezone) {
		this.timezone = timezone;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getCod() {
		return cod;
	}
	public void setCod(Long cod) {
		this.cod = cod;
	}
	@Override
	public String toString() {
		return "OpenWeatherMap [coord=" + coord + ", weather=" + Arrays.toString(weather) + ", base=" + base + ", main="
				+ main + ", visibility=" + visibility + ", wind=" + wind + ", rain=" + rain + ", clouds=" + clouds
				+ ", snow=" + snow + ", dt=" + dt + ", sys=" + sys + ", timezone=" + timezone + ", id=" + id + ", name="
				+ name + ", cod=" + cod + "]";
	}
	
	
}
