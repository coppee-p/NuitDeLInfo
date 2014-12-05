package models;

import java.util.Iterator;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import play.db.ebean.Model;

public class Camp extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer id;

	@NotBlank
	protected String name;

	@NotNull
	protected Double latitude;
	@NotNull
	protected Double longitude;

	@NotBlank
	protected String country;
	@NotEmpty
	protected String region;

	@NotNull
	protected CampStatus state;

	@Min(1)
	protected Integer size;

	@OneToMany(mappedBy = "camp")
	protected Set<User> users;

	public static Finder<Integer, Camp> finder = new Finder<Integer, Camp>(
			Integer.class, Camp.class);

	public Camp(Integer id, String name, Double latitude, Double longitude,
			String country, String region, CampStatus state, Integer size) {
		this.id = id;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.country = country;
		this.region = region;
		this.state = state;
		this.size = size;
	}

	public boolean isNear(Double latitude, Double longitude) {
		// TODO
		return false;
	}

	public boolean isFull() {
		return getLeftSize() == size;
	}

	public int getLeftSize() {
		return size - users.size();
	}

	static enum CampStatus {
		CLOSED, OPENED
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public CampStatus getState() {
		return state;
	}

	public void setState(CampStatus state) {
		this.state = state;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

}
