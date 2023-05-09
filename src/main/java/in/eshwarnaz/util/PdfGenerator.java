package in.eshwarnaz.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.eshwarnaz.entity.CitizenPlan;

@Service
public class PdfGenerator {

	public void pdfGenerator(HttpServletResponse responce, List<CitizenPlan> records, File f)
			throws DocumentException, IOException {

		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, responce.getOutputStream());
		PdfWriter.getInstance(document, new FileOutputStream(f));
		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLDOBLIQUE);
		Paragraph p = new Paragraph("Citizen Plan Info", font);
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

		for (CitizenPlan plan : records) {
			table.addCell(String.valueOf(plan.getCITEGEN_ID()));
			table.addCell(plan.getCITEGEN_NAME());
			table.addCell(plan.getCITEGENPLANNAME());
			table.addCell(plan.getCITEGEN_GENDER());
			table.addCell(plan.getCITEGENPLANSTATUS());
			table.addCell(plan.getSTART_DATE() + "");
			table.addCell(plan.getEND_DATE() + "");
			table.addCell(plan.getBENFITAMOUNT() + "");
		}
		document.add(table);
		document.close();
	}

}
