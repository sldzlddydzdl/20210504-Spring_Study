package user;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class User {
	private int id;
	private String userId;
	private String password;
	private LocalDate birthDate;
	private LocalDateTime joinDate;
	
	public User() {
		super();
	}
	
	
	public User(int id, String userId, String password, LocalDate birthDate, LocalDateTime joinDate) {
		super();
		this.id = id;
		this.userId = userId;
		this.password = password;
		this.birthDate = birthDate;
		this.joinDate = joinDate;
	}


	public LocalDateTime getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDateTime joinDate) {
		this.joinDate = joinDate;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userId=" + userId + ", password=" + password + ", birthDate=" + birthDate
				+ ", joinDate=" + joinDate + "]";
	}
	
}
