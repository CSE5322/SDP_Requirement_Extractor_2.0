package BusinessObjects;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.FileOutputStream;

public class ExportDoc extends Export {
	
	@Override
	public void ExportData() {
		XWPFDocument document = new XWPFDocument();
		XWPFParagraph paragraph = document.createParagraph();
		XWPFRun run = paragraph.createRun();
		
		run.setText(requirementData);
		
		FileOutputStream output;
		try {
			output = new FileOutputStream("Requirements.docx");
			document.write(output);
			output.close();
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
