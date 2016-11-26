package BusinessObjects;

public class ExportRequirement {
	String requirementData;
	String filePath;
	public void ExportData(String requirement, String path, String extension){
		requirementData = requirement;
		filePath = path;
		switch(extension){
		case ("pdf"):{
			ExportPdf pdf = new ExportPdf();
			pdf.ExportDataPdf();
		}
		case ("txt"):{
			ExportTxt txt = new ExportTxt();
			txt.ExportDataTxt();
		}
		case ("doc"):{
			ExportDoc doc = new ExportDoc();
			doc.ExportDataDoc();
		}
		}
	};
}
