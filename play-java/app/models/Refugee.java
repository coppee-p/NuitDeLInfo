package models;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Nullable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Refugee extends User {

	private static final long serialVersionUID = 1L;

	@NotNull
	protected Date birthday;
	@NotNull
	protected String birthPlace;
	@NotNull
	protected RefugeeHealth healthState;
	protected Double latitude;
	protected Double longitude;

	public static enum RefugeeHealth {
		DEAD, CRITICAL, WOUNDED, STABLE, HEALTHY
	}

	@ManyToOne
	@Nullable
	protected Incident incident;

	@Nullable
	protected Timestamp arriveDate;
	@Nullable
	protected Timestamp leaveDate;

	public Refugee(String login, String password, String email,
			String firstname, String lastname, Date birthday,
			String birthPlace, RefugeeHealth healthState, Double latitude,
			Double longitude, Timestamp arriveDate, Timestamp leaveDate) {
		super(login, password, email);
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthday = birthday;
		this.birthPlace = birthPlace;
		this.healthState = healthState;
		this.latitude = latitude;
		this.longitude = longitude;
		this.arriveDate = arriveDate;
		this.leaveDate = leaveDate;
	}

	public void moveToCamp(Camp c) {
		setCamp(c);
		save();
	}

	public Incident getIncident() {
		return incident;
	}

	public void setIncident(Incident incident) {
		this.incident = incident;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public RefugeeHealth getHealthState() {
		return healthState;
	}

	public void setHealthState(RefugeeHealth healthState) {
		this.healthState = healthState;
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

	public Timestamp getArriveDate() {
		return arriveDate;
	}

	public void setArriveDate(Timestamp arriveDate) {
		this.arriveDate = arriveDate;
	}

	public Timestamp getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(Timestamp leaveDate) {
		this.leaveDate = leaveDate;
	}

}