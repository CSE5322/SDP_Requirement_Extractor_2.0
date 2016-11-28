package exportDocument;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.FileOutputStream;

public class ExportDoc extends ExportRequirement {

	public void ExportDataDoc() {
		XWPFDocument document = new XWPFDocument();
		XWPFParagraph paragraph = document.createParagraph();
		XWPFRun run = paragraph.createRun();
		
		requirementData.replace("\n", "<w:br/>");
		run.setText(requirementData);
		
		FileOutputStream output;
		try {
			output = new FileOutputStream(filePath);
			document.write(output);
			output.close();
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
