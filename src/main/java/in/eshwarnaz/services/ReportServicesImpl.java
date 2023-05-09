package in.eshwarnaz.services;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import in.eshwarnaz.entity.CitizenPlan;
import in.eshwarnaz.repository.CitizenPlanRepositroy;
import in.eshwarnaz.request.SearchRequest;
import in.eshwarnaz.util.EmailSender;
import in.eshwarnaz.util.ExcelGenerator;
import in.eshwarnaz.util.PdfGenerator;

@Service
public class ReportServicesImpl implements ReportServices {

	@Autowired
	private CitizenPlanRepositroy repository;

	@Autowired
	private PdfGenerator pdfgenrator;

	@Autowired
	private ExcelGenerator excelgenrator;

	@Autowired
	private EmailSender emailsender;

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
	public boolean exportExcel(HttpServletResponse responce) throws Exception {
		List<CitizenPlan> findAll = repository.findAll();
		excelgenrator.excelGenrator(responce, findAll);
		String subject = "Hi EshwarNaz";
		String body = "<h1>Hi</h1>";
		String to = "nazeshwar701@gmail.com";
		File f = new File("plans.xls");
		emailsender.emailSender(subject, body, to, f);
		f.delete();
		return true;
	}

	@Override
	public boolean exportPdf(HttpServletResponse responce) throws Exception, IOException {

		List<CitizenPlan> list = repository.findAll();
		File f = new File("plans.pdf");
		pdfgenrator.pdfGenerator(responce, list, f);
		String subject = "Hi EshwarNaz";
		String body = "<h1>Hi</h1>";
		String to = "nazeshwar701@gmail.com";
		emailsender.emailSender(subject, body, to, f);
		f.delete();
		return true;
	}

}
