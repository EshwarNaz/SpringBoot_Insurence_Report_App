package in.eshwarnaz.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.eshwarnaz.entity.CitizenPlan;
import in.eshwarnaz.repository.CitizenPlanRepositroy;
import in.eshwarnaz.request.SearchRequest;

@Service
public class ReportServicesImpl implements ReportServices {

	@Autowired
	private CitizenPlanRepositroy repository;

	@Override
	public List<String> planName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> planStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exportExcel() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean exportPdf() {
		// TODO Auto-generated method stub
		return false;
	}

}
