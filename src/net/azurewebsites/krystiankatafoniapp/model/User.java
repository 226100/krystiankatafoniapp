package net.azurewebsites.krystiankatafoniapp.model;

import java.util.Objects;
/**
 * User class is a model class of one user
 * This model is correspond with the data
 * about user in database
 * @author Krystian Katafoni
 * @version 1.0
 * @since 2017-06-20
 */
public class User {
	/*User id in database */
	private Long id;
	private String username;
	private String email;
	private String password;
	/*If user is active true, if not false*/
	private boolean active;

	public User() {
	};

	public User(User user) {
		this.id = user.id;
		this.username = user.username;
		this.email = user.email;
		this.active = user.active;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	};

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + ", active="
				+ active + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, username, email, password, active);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof User) {
			User user = (User) obj;
			return Objects.equals(id, user.id) && Objects.equals(username, user.username)
					&& Objects.equals(email, user.email) && Objects.equals(password, user.password)
					&& Objects.equals(active, user.active);

		}
		return false;
	}
}
