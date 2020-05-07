package library_management_system_spring_angular.dto;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Embeddable
public class BooksBorrowedPrimaryKeyDto implements Serializable{

	private int bookId;

	private String email;
}
