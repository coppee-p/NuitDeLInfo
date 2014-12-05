package models;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Staff extends User {

	private static final long serialVersionUID = 1L;
	protected StaffRole role;

	@OneToMany(mappedBy = "creator")
	protected Set<Event> events;

	public Staff(String login, String password, String email, StaffRole role) {
		super(login, password, email);
		this.role = role;
	}

	public Set<Event> getEvents() {
		return events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}

	public StaffRole getRole() {
		return role;
	}

	public void setRole(StaffRole role) {
		this.role = role;
	}

	public static enum StaffRole {
		ON_SITE, CAMP_MANAGER, OFFICE, ADMINISTRATOR
	}
}
