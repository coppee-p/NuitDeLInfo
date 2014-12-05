package models;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import play.db.ebean.Model;

@Entity
public class Incident extends Model {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer id;
	@NotNull
	protected IncidentType type;

	protected Double latitude;
	protected Double longitude;

	protected Date date;

	@OneToMany(mappedBy = "incident")
	protected Set<Refugee> refugees;

	public Incident(Integer id, IncidentType type, Double latitude,
			Double longitude, Date date) {
		this.id = id;
		this.type = type;
		this.latitude = latitude;
		this.longitude = longitude;
		this.date = date;
	}

	public Set<Refugee> getRefugees() {
		return refugees;
	}

	public void setRefugees(Set<Refugee> refugees) {
		this.refugees = refugees;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public IncidentType getType() {
		return type;
	}

	public void setType(IncidentType type) {
		this.type = type;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	static enum IncidentType {
		ATTACK, DISEASE, STARVATION, IDEOLOGICAL, DISASTER
	}
}
