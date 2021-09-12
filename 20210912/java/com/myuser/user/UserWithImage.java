package com.myuser.user;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

public class UserWithImage {
	private int id;
	private String userId;
	private String password;
	// 클라이언트로부터 yyyy-MM-dd 모양으로 들어왔을 때 넣어줌
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthDate;
	// 클라이언트로부터 yyyy-MM-dd HH:mm:ss 모양으로 들어왔을 때 넣어줌
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime joinDate;
	
	private String imageFileName;

	public UserWithImage() {
		super();
	}

	public UserWithImage(int id, String userId, String password, LocalDate birthDate, LocalDateTime joinDate,
			String imageFileName) {
		super();
		this.id = id;
		this.userId = userId;
		this.password = password;
		this.birthDate = birthDate;
		this.joinDate = joinDate;
		this.imageFileName = imageFileName;
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

	public LocalDateTime getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDateTime joinDate) {
		this.joinDate = joinDate;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	@Override
	public String toString() {
		return "UserWithImage [id=" + id + ", userId=" + userId + ", password=" + password + ", birthDate=" + birthDate
				+ ", joinDate=" + joinDate + ", imageFileName=" + imageFileName + "]";
	}
	
	
	
}
