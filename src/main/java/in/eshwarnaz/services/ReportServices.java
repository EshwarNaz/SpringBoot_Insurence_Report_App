package in.eshwarnaz.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import in.eshwarnaz.entity.CitizenPlan;
import in.eshwarnaz.request.SearchRequest;

public interface ReportServices {
	public List<String> planName();

	public List<String> planStatus();

	public List<CitizenPlan> search(SearchRequest request);

	public boolean exportExcel(HttpServletResponse responce) throws Exception;

	public boolean exportPdf(HttpServletResponse responce) throws Exception, IOException;

}
