package library_management_system_spring_angular.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LMSResponse {

	private boolean error;
	private String message;
	
	private InformationDto information;
	private List<InformationDto> informationList;
	
	private BookDto book;
	private List<BookDto> bookList;
	
	private BookIssueDetailsDto issueDetails;
	private List<BookIssueDetailsDto> issueDetailsList ;
	
	private BookIssueDetailsPrimaryKeyDto issueDetailsPrimary;
	private List<BookIssueDetailsPrimaryKeyDto> issueDetailsPrimaryList ;
	
	private BooksBorrowedDto borrowedDetails;
	private List<BooksBorrowedDto> borrowedDetailsList ;
	
	private BooksBorrowedPrimaryKeyDto borrowedDetailPrimarly;
	private List<BooksBorrowedPrimaryKeyDto> borrowedDetailsPrimaryList ;
	
	private RequestDto request;
	private List<RequestDto> requestList  ;
	
	private RequestPrimaryKeyDto requestPrimary;
	private List<RequestPrimaryKeyDto> requestPrimaryList  ;
	
//	private LMSResponse response;
//	private List<LMSResponse> responseList  ;
//	
	
	
	
	
	
	
	

}
