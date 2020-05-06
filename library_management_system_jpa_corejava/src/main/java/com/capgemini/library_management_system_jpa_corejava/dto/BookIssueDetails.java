package com.capgemini.library_management_system_jpa_corejava.dto;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;

@Data
@Entity
@Table(name = "bookissue")
public class BookIssueDetails {

	@EmbeddedId
	private BookIssueDetailsPrimaryKey bookIssueDetailsPrimaryKey;
	
	@Column
	private int id;
	

	@Temporal(TemporalType.DATE)
	@Column(name = "issueDate")
	private java.util.Date Date = new java.util.Date();
	@Column
	private Date returnDate;

	 @Exclude 
	  // @MapsId 
	  
	  @ManyToOne(cascade=CascadeType.ALL)
	  
	  @JoinColumn(name="id" , insertable = false,updatable = false)
	  private InformationDto primary;
	 
}
