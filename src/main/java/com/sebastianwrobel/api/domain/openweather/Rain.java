package com.sebastianwrobel.api.domain.openweather;

import com.fasterxml.jackson.annotation.JsonAlias;

public class Rain {
	@JsonAlias("1h")
	private Double oneh;
	
	@JsonAlias("3h")
	private Double threeh;

	public Double getOneh() {
		return oneh;
	}

	public void setOneh(Double oneh) {
		this.oneh = oneh;
	}

	public Double getThreeh() {
		return threeh;
	}

	public void setThreeh(Double threeh) {
		this.threeh = threeh;
	}

	@Override
	public String toString() {
		return "Rain [oneh=" + oneh + ", threeh=" + threeh + "]";
	}

	
	
}
