package in.eshwarnaz.request;

import java.time.LocalDate;

import lombok.Data;
@Data
public class SearchRequest {
	private String PLAN_NAME;
	private String PLAN_STATUS;
	private String GENDER;
	private LocalDate STARTDATE;
	private LocalDate ENDDATE;

}
