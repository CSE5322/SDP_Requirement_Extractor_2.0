package exportDocument;

public class ExportRequirement {
	static String  requirementData;
	static String filePath;
	
	public void ExportData(String requirement, String path, String extension){
		requirementData = requirement;
		filePath = path;
		if(extension.equals("pdf")){
			ExportPdf pdf = new ExportPdf();
			pdf.ExportDataPdf();
		}
		else if (extension.equals("doc")){
			ExportDoc doc = new ExportDoc();
			doc.ExportDataDoc();
		}
		else if (extension.equals("txt")){
			ExportTxt txt = new ExportTxt();
			txt.ExportDataTxt();
		}
		else if (extension.equals("xml")){
			ExportXML xml = new ExportXML();
			xml.ExportDataXML();
		}
	};
}
