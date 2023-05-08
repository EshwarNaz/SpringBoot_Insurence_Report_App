package in.eshwarnaz.services;

import java.awt.Color;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

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
	public boolean exportExcel(HttpServletResponse responce) throws Exception {

		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet();
		Row headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue("Id");
		headerRow.createCell(1).setCellValue("Citizen Name");
		headerRow.createCell(2).setCellValue("Plan Name");
		headerRow.createCell(3).setCellValue("Gender");
		headerRow.createCell(4).setCellValue("Plan Status");
		headerRow.createCell(5).setCellValue("Plan Start Date");
		headerRow.createCell(6).setCellValue("Plan End Date");
		headerRow.createCell(7).setCellValue("Benfit Amount");

		List<CitizenPlan> records = repository.findAll();
		int dataRowIndex = 1;
		for (CitizenPlan plan : records) {
			Row dataRow = sheet.createRow(dataRowIndex);
			dataRow.createCell(0).setCellValue(plan.getCITEGEN_ID());
			dataRow.createCell(1).setCellValue(plan.getCITEGEN_NAME());
			dataRow.createCell(2).setCellValue(plan.getCITEGENPLANNAME());
			dataRow.createCell(3).setCellValue(plan.getCITEGEN_GENDER());
			dataRow.createCell(4).setCellValue(plan.getCITEGENPLANSTATUS());
			if (null != plan.getBENFITAMOUNT()) {
				dataRow.createCell(5).setCellValue(plan.getSTART_DATE() + "");
			} else {
				dataRow.createCell(5).setCellValue("N/A");
			}
			if (null != plan.getBENFITAMOUNT()) {
				dataRow.createCell(6).setCellValue(plan.getEND_DATE() + "");
			} else {
				dataRow.createCell(6).setCellValue("N/A");
			}

			if (null != plan.getBENFITAMOUNT()) {
				dataRow.createCell(7).setCellValue(plan.getBENFITAMOUNT());
			} else {
				dataRow.createCell(7).setCellValue("N/A");
			}

			dataRowIndex++;
		}

		ServletOutputStream outputStream = responce.getOutputStream();
		workbook.write(outputStream);
		workbook.close();

		return true;
	}

	@Override
	public boolean exportPdf(HttpServletResponse responce) throws Exception, IOException {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, responce.getOutputStream());
		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLDOBLIQUE);	
		Paragraph p = new Paragraph("Citizen Plan Info" , font);
		p.setAlignment(p.ALIGN_CENTER);
		document.add(p);
		PdfPTable table = new PdfPTable(8);
		table.setWidthPercentage(100f);
		table.setSpacingBefore(5);
		table.addCell("Id");
		table.addCell("Citizen Name");
		table.addCell("Plan Name");
		table.addCell("Gender");
		table.addCell("Plan Status");
		table.addCell("Plan StartDate");
		table.addCell("Plan EndDate");
		table.addCell("Benfit Amount");
		
		List<CitizenPlan> records = repository.findAll();
		for(CitizenPlan plan : records) {
			table.addCell(String.valueOf(plan.getCITEGEN_ID()));
			table.addCell(plan.getCITEGEN_NAME());
			table.addCell(plan.getCITEGENPLANNAME());
			table.addCell(plan.getCITEGEN_GENDER());
			table.addCell(plan.getCITEGENPLANSTATUS());
			table.addCell(plan.getSTART_DATE()+"");
			table.addCell(plan.getEND_DATE()+"");
			table.addCell(plan.getBENFITAMOUNT()+"");		
		}
		document.add(table);
		document.close();

		return false;
	}

}
