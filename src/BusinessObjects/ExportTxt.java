package BusinessObjects;

import java.io.PrintWriter;

public class ExportTxt extends Export{

	@Override
	public void ExportData() {
		try {
			PrintWriter writer = new PrintWriter("Requirement.txt", "UTF-8");
			writer.println(requirementData);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
