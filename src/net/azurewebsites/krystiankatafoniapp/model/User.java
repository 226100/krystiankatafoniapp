package net.azurewebsites.krystiankatafoniapp.model;

import java.util.Objects;

public class User {
	private long id;
	private String username;
	private String email;
	private String password;
	private boolean active;

	public User() {
	};

	public User(User user) {
		this.id = user.id;
		this.username = user.username;
		this.email = user.email;
		this.active = user.active;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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
