package com.qa.qaDafneBoutiqueHotel.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DafneReservations {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false, length = 25)
	private String suite;

	@Column(nullable = false, length = 25)
	private String bedsize;

	@Column(nullable = false)
	private float price;

	@Column(nullable = false)
	private boolean breakfast;

	public DafneReservations() {
		super();

	}

// Construction without Id
	public DafneReservations(String suite, String bedsize, float price, boolean breakfast) {
		super();
		this.suite = suite;
		this.bedsize = bedsize;
		this.price = price;
		this.breakfast = breakfast;
	}

// Constructor with id
	public DafneReservations(long id, String suite, String bedsize, float price, boolean breakfast) {
		super();
		this.id = id;
		this.suite = suite;
		this.bedsize = bedsize;
		this.price = price;
		this.breakfast = breakfast;

// getters and setters

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSuite() {
		return suite;
	}

	public void setSuite(String suite) {
		this.suite = suite;
	}

	public String getBedsize() {
		return bedsize;
	}

	public void setBedsize(String bedsize) {
		this.bedsize = bedsize;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public boolean isBreakfast() {
		return breakfast;
	}

	public void setBreakfast(boolean breakfast) {
		breakfast = breakfast;
	}

//Hash

	@Override
	public int hashCode() {
		return Objects.hash(breakfast, bedsize, id, price, suite);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DafneReservations other = (DafneReservations) obj;
		return breakfast == other.breakfast && Objects.equals(bedsize, other.bedsize) && id == other.id
				&& Float.floatToIntBits(price) == Float.floatToIntBits(other.price)
				&& Objects.equals(suite, other.suite);
	}

// ToString

	@Override
	public String toString() {
		return "DafneReservations [id=" + id + ", suite=" + suite + ", bedsize=" + bedsize + ", price=" + price
				+ ", breakfast=" + breakfast + "]";

	}

}
