package com.capgemini.library_management_system_jpa_corejava.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Data
@Table(name="Information")
public class InformationDto implements Serializable {
	
	@Id
	@Column(name="Id")
	private int id;
	@Column(name="Name")
	private String name;
	@Column(name="Email")
	private String email;
	@Column(name="Password")
	private String password;
	@Column(name="Role")
	private String typeOfUser;
	
		
	@OneToMany(cascade=CascadeType.ALL,mappedBy="primary",fetch = FetchType.EAGER) 
	  private List<RequestDTO> reqBook;
	  
	  @OneToMany(cascade=CascadeType.ALL,mappedBy="primary") private
	  List<BookIssueDetails> bookIssue;
	 
	@OneToMany(cascade=CascadeType.ALL,mappedBy="primary")
	private List<BooksBorrowedDTO> borrowBook;
	}
	
	
	
	

