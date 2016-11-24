package BusinessObjects;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

public class ExportPdf extends Export{

	@Override
	public void ExportData() {
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream("Requirement.pdf"));
			document.open();
			Paragraph paragraph = new Paragraph();
			paragraph.add(requirementData);
			document.add(paragraph);
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
