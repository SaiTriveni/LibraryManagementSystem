package com.capgemini.library_management_system_jpa_corejava.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Data
@Table(name="Book")
public class BookDTO {
	@Id
	@Column(name="Book_Id")
	private int bookId;
	@Column(name="Book_Title")
	private String bookTitle;
	@Column(name="Book_Author")
	private String bookAuthor;
	@Column(name="Book_Type")
	private String bookType;
	@Column(name="Book_publisher")
	private String bookPublisher;
}
