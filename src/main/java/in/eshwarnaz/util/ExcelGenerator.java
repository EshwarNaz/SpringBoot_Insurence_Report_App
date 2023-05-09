package in.eshwarnaz.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import in.eshwarnaz.entity.CitizenPlan;

@Service
public class ExcelGenerator {

	public void excelGenrator(HttpServletResponse responce, List<CitizenPlan> records) throws Exception {

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

		FileOutputStream fos = new FileOutputStream(new File("plans.xls"));
		workbook.write(fos);
		fos.close();

		ServletOutputStream outputStream = responce.getOutputStream();
		workbook.write(outputStream);
		workbook.close();

	}

}
