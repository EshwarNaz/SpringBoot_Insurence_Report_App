package in.eshwarnaz.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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

		return repository.getPlanNames();
	}

	@Override
	public List<String> planStatus() {

		return repository.getPlanStatus();
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {
		CitizenPlan entity = new CitizenPlan();
		if (null != request.getPLANNAME() && !"".equals(request.getPLANNAME())) {
			entity.setCITEGENPLANNAME(request.getPLANNAME());
		}
		if (null != request.getPLANSTATUS() && !"".equals(request.getPLANSTATUS())) {
			entity.setCITEGENPLANSTATUS(request.getPLANSTATUS());
		}
		if (null != request.getGENDER() && !"".equals(request.getGENDER())) {
			entity.setCITEGEN_GENDER(request.getGENDER());
		}
		if (null != request.getSTARTDATE() && !"".equals(request.getSTARTDATE())) {
			String date = request.getSTARTDATE();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate = LocalDate.parse(date, formatter);
			entity.setSTART_DATE(localDate);

		}
		if (null != request.getENDDATE() && !"".equals(request.getENDDATE())) {
			String date = request.getENDDATE();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate = LocalDate.parse(date, formatter);
			entity.setEND_DATE(localDate);

		}

		return repository.findAll(Example.of(entity));
	}

	@Override
	public boolean exportExcel() {
		return false;
	}

	@Override
	public boolean exportPdf() {
		return false;
	}

}
