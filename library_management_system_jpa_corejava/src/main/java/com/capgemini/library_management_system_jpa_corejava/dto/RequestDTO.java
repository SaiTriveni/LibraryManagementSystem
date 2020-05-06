package com.capgemini.library_management_system_jpa_corejava.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode.Exclude;
@Entity
@Table(name="RequestDTO")
public class RequestDTO {
	
	@EmbeddedId
	private RequestDtoPrimaryKey requestDtoPrimaryKey;
	
    @Column
    private int id;
    
    @Column
    private String name;
	
    @Column
	private String bookTitle;
    
    @Exclude 
	  // @MapsId
	  
	  @ManyToOne(cascade=CascadeType.ALL)
	  
	  @JoinColumn(name="id" , insertable = false ,updatable = false) 
	  private InformationDto primary;



	public RequestDtoPrimaryKey getRequestDtoPrimaryKey() {
		return requestDtoPrimaryKey;
	}



	public void setRequestDtoPrimaryKey(RequestDtoPrimaryKey requestDtoPrimaryKey) {
		this.requestDtoPrimaryKey = requestDtoPrimaryKey;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getBookTitle() {
		return bookTitle;
	}



	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}



	public InformationDto getPrimary() {
		return primary;
	}



	public void setPrimary(InformationDto primary) {
		this.primary = primary;
	}



	@Override
	public String toString() {
		return "RequestDTO [requestDtoPrimaryKey=" + requestDtoPrimaryKey + ", id=" + id + ", name=" + name
				+ ", bookTitle=" + bookTitle + ", primary=" + primary + "]";
	}
	
    
	
}
