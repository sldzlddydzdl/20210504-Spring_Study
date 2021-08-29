package com.myboard.myboard.model;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
//생성자,getter,setter,toString
public class BoardDto {
	private int id;
	private String title;
	private String content;
	private String writer;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime writeDate;
	private LocalDateTime updateDate;
	public BoardDto(int id, String title, String content, String writer, LocalDateTime writeDate,
			LocalDateTime updateDate) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.writeDate = writeDate;
		this.updateDate = updateDate;
	}
	
	public BoardDto() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public LocalDateTime getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(LocalDateTime writeDate) {
		this.writeDate = writeDate;
	}

	public LocalDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "BoardDto [id=" + id + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", writeDate=" + writeDate + ", updateDate=" + updateDate + "]";
	}
}
