package models;

import java.util.Date;

import javax.annotation.Nullable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import play.db.ebean.Model;

public class Event extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer id;

	protected String title;

	protected EventType type;

	protected Double latitude;
	protected Double longitude;

	protected String description;

	protected Date beginning;
	@Nullable
	protected Date end;

	@ManyToOne
	protected Staff creator;

	public Event(Integer id, String title, EventType type, Double latitude,
			Double longitude, String description, Date beginning, Date end) {
		this.id = id;
		this.title = title;
		this.type = type;
		this.latitude = latitude;
		this.longitude = longitude;
		this.description = description;
		this.beginning = beginning;
		this.end = end;
	}

	public Staff getCreator() {
		return creator;
	}

	public void setCreator(Staff creator) {
		this.creator = creator;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public EventType getType() {
		return type;
	}

	public void setType(EventType type) {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getBeginning() {
		return beginning;
	}

	public void setBeginning(Date beginning) {
		this.beginning = beginning;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	static enum EventType {
		ALERT, NEWS, PREVENTION
	}

}
