package library_management_system_spring_angular.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name="BooksBorrowedDTO")
public class BooksBorrowedDto implements Serializable{

	@EmbeddedId
	private BooksBorrowedPrimaryKeyDto booksBorrowedDtoPrimaryKey;
	
	@Column
	private int id;
	
	@Exclude //@MapsId
	  
	  @ManyToOne
	  
	  @JoinColumn(name="id" , insertable = false,updatable = false) 
	  private InformationDto primary;
}
