package library_management_system_spring_angular.dto;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Embeddable
public class RequestPrimaryKeyDto implements Serializable{

	private int bookId;
	
	private String email;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "RequestDtoPrimaryKey [bookId=" + bookId + ", email=" + email + "]";
	}
	
	
}
