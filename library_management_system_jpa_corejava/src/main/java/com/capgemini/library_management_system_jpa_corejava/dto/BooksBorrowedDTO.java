package com.capgemini.library_management_system_jpa_corejava.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;

@Data
@Entity
@Table(name="BooksBorrowedDTO")
public class BooksBorrowedDTO implements Serializable{

	@EmbeddedId
	private BooksBorrowedDtoPrimaryKey booksBorrowedDtoPrimaryKey;
	
	@Column
	private int id;
	
	@Exclude //@MapsId
	  
	  @ManyToOne
	  
	  @JoinColumn(name="id" , insertable = false,updatable = false) 
	  private InformationDto primary;
}
