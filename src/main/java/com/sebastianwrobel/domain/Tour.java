package com.sebastianwrobel.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Tour {

	public enum Continent {
		AFRICA, ASIA, EUROPE, NORTH_AMERICA, SOUTH_AMERICA;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	
	@NotBlank(message = "Tour name cannot be blank")
	@Size(min = 5, message = "Minimum 5 characters")
	private String name;
	
	//regex pattern: 2 letters - (dash) 2 numbers and a letter
	@Pattern(regexp = "^[a-zA-Z]{2}-[0-9]{2}[a-zA-Z]{1}$" , message = "Expected format is CC-DDC (C - character, D - digit)")
	private String code;
	
	private Continent continent;
	
	@NotNull(message = "Please select the date")
	@Future
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	
	@Min(value = 7, message = "Duration should be between 7 - 21 days")
	@Max(value = 21, message = "Duration should be between 7 - 21 days")
	@NotNull(message = "Duration should be between 7 - 21 days")
	private Integer duration;
	
	@Column(name = "all_inclusive")
	private Boolean allInclusive = false;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tour_details_id")
	private TourDetails tourDetails;
	
	@OneToMany(mappedBy = "tour", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Comment> comments;
	
	
	public TourDetails getTourDetails() {
		return tourDetails;
	}

	public void setTourDetails(TourDetails tourDetails) {
		this.tourDetails = tourDetails;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Continent getContinent() {
		return continent;
	}

	public void setContinent(Continent continent) {
		this.continent = continent;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getAllInclusive() {
		return allInclusive;
	}

	public void setAllInclusive(Boolean allInclusive) {
		this.allInclusive = allInclusive;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

// one to many does not work yet
	// 27.07

}
