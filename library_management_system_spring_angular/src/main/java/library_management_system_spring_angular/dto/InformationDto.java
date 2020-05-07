package library_management_system_spring_angular.dto;

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
@SuppressWarnings("serial")
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
	  private List<RequestDto> reqBook;
	  
	  @OneToMany(cascade=CascadeType.ALL,mappedBy="primary") private
	  List<BookIssueDetailsDto> bookIssue;
	 
	@OneToMany(cascade=CascadeType.ALL,mappedBy="primary")
	private List<BooksBorrowedDto> borrowBook;
	}
	
	
	
	

