package in.eshwarnaz.services;

import java.util.List;

import in.eshwarnaz.entity.CitizenPlan;
import in.eshwarnaz.request.SearchRequest;

public interface ReportServices {
	public List<String> planName();

	public List<String> planStatus();

	public List<CitizenPlan> search(SearchRequest request);

	public boolean exportExcel();

	public boolean exportPdf();

}
