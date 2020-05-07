package library_management_system_spring_angular.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import library_management_system_spring_angular.dto.BookDto;
import library_management_system_spring_angular.dto.InformationDto;
import library_management_system_spring_angular.dto.LMSResponse;
import library_management_system_spring_angular.service.AdminService;
import org.springframework.http.MediaType;;
@RestController
public class LibraryManagementSystemRestController {

	@Autowired
	private AdminService service;

	@PostMapping(path = "/addInfo", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
//	@ResponseBody
	public LMSResponse addInfo(@RequestBody InformationDto admin) {
		boolean isAdded = service.register(admin);
		LMSResponse response = new LMSResponse();
		if (isAdded) {
			response.setMessage("Record Inserted SucessFully");
		} else {
			response.setError(true);
			response.setMessage("unable to Register");
		}
		return response;
	}

	@PostMapping(path = "/addBook", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public LMSResponse addBook(@RequestBody BookDto book) {
		boolean isAdded = service.addBook(book);

		LMSResponse response = new LMSResponse();
		if (isAdded) {
			response.setMessage("Record is inserted Successfully");
		} else {
			response.setError(true);
			response.setMessage("Record is not inserted");
		}
		return response;
	}

	@GetMapping(path = "/getBooksByTitle", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public LMSResponse getBooksByTitle(@RequestBody String bookTitle) {
		List<BookDto> recordList = service.searchBookTitle(bookTitle);
		LMSResponse response = new LMSResponse();

		if (recordList != null && !recordList.isEmpty()) {
			response.setBookList(recordList);
		} else {
			response.setError(true);
			response.setMessage("Book with given Title not present");
		}
		return response;

	}
	
	@GetMapping(path = "/getBooksByAuthor", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public LMSResponse getBooksByAuthor(@RequestBody String bookAuthor) {
		List<BookDto> recordList = service.searchBookAuthor(bookAuthor);
		LMSResponse response = new LMSResponse();

		if (recordList != null && !recordList.isEmpty()) {
			response.setBookList(recordList);
		} else {
			response.setError(true);
			response.setMessage("The given Author not Found");
		}
		return response;

	}
	
	@GetMapping(path = "/getBooksByType", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public LMSResponse getBooksByType(@RequestBody String bookTitle) {
		List<BookDto> recordList = service.searchBookTitle(bookTitle);
		LMSResponse response = new LMSResponse();

		if (recordList != null && !recordList.isEmpty()) {
			response.setBookList(recordList);
		} else {
			response.setError(true);
			response.setMessage("The Given Type  is not Found");
		}
		return response;

	}
	
	@DeleteMapping(path="/deleteEmployee/{id}",
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public LMSResponse deleteEmployee(@PathVariable(name="id")int bookId) {
		 boolean isDeleted=service.removeBook(bookId);
		 LMSResponse response=new LMSResponse();
		 if(isDeleted) {
			 response.setMessage("The Given Record is Sucessfully deleted");
			 
		 }else {
			 response.setError(true);
			 response.setMessage("Record is Not Found");
		 }
		 
		 return response;
	}


}
