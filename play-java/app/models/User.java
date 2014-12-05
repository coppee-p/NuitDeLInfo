package models;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.annotation.Nullable;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.hibernate.validator.constraints.NotBlank;

import play.data.validation.Constraints.Email;
import play.data.validation.Constraints.MinLength;
import play.db.ebean.Model;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
abstract public class User extends Model {
	private static final long serialVersionUID = 1L;

	@Id
	@MinLength(5)
	protected String login;
	@MinLength(8)
	protected String password;
	@Nullable
	@Email
	protected String email;

	@NotBlank
	@MinLength(2)
	protected String firstname;
	@NotBlank
	@MinLength(2)
	protected String lastname;

	@ManyToOne
	@Nullable
	protected Camp camp;

	static Finder<String, User> finder = new Finder<String, User>(String.class,
			User.class);

	public static Finder<String, User> find = new Finder<String, User>(
			String.class, User.class);

	public User(String login, String password, String email) {
		this.login = login;
		this.password = password;
		this.email = email;
	}

	public static Set<User> searchUser(String keyword) {
		Set<User> users = new HashSet<User>();
		for (Iterator<User> iterator = finder.all().iterator(); iterator
				.hasNext();) {
			User user = iterator.next();
			if (user.matchUser(keyword)) {
				users.add(user);
			}
		}

		return users;
	}

	public boolean matchUser(String keyword) {
		return firstname.contains(keyword) || lastname.contains(keyword);
	}

	public Camp getCamp() {
		return camp;
	}

	public void setCamp(Camp camp) {
		this.camp = camp;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
