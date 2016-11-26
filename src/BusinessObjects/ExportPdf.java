package BusinessObjects;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

public class ExportPdf extends ExportRequirement{

	public void ExportDataPdf() {
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream(filePath));
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
