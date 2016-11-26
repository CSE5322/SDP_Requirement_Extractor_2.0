package exportDocument;

import java.io.PrintWriter;

public class ExportTxt extends ExportRequirement{

	public void ExportDataTxt() {
		try {
			PrintWriter writer = new PrintWriter(filePath, "UTF-8");
			writer.println(requirementData);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
