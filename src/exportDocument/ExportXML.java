package exportDocument;

import java.io.File;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import Controller.DefineBusinessProcessController;

import composite.CompositeComponent;
import composite.PrimitiveComponent;
import composite.RequirementComponent;


public class ExportXML extends ExportRequirement {

	public void ExportDataXML() {
		DefineBusinessProcessController bpCntrl = new DefineBusinessProcessController();
		TreeModel model = bpCntrl.getCompleteModel();
		try {
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			Document doc = factory.newDocumentBuilder().newDocument();
			DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
			parseTreeNode(root, doc);

			Transformer tf = TransformerFactory.newInstance().newTransformer();
			tf.setOutputProperty(OutputKeys.INDENT, "yes");
			tf.setOutputProperty(OutputKeys.METHOD, "xml");
			tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

			DOMSource domSource = new DOMSource(doc);
			StreamResult sr = new StreamResult(new File(filePath));
			tf.transform(domSource, sr);
			
		} catch (ParserConfigurationException | TransformerException ex) {
			ex.printStackTrace();
		}
	}

	protected static void parseTreeNode(DefaultMutableTreeNode treeNode, Document doc) {
		CompositeComponent compRoot = (CompositeComponent) treeNode;
		String value = compRoot.getPhrase().getSentence();
		Element rootElement = doc.createElement(value);
		doc.appendChild(rootElement);
		List<RequirementComponent> childList = compRoot.getChild();
		for (int i = 0; i < childList.size(); i++){
			CompositeComponent childBP = (CompositeComponent) childList.get(i);
			String childvalue = childBP.getPhrase().getSentence();
			Element childElement = rootElement.getOwnerDocument().createElement("BusinessProcess");
			Attr attrName = rootElement.getOwnerDocument().createAttribute("value");
			attrName.setNodeValue(childvalue);
			childElement.getAttributes().setNamedItem(attrName);
			rootElement.appendChild(childElement);
			List<RequirementComponent> childListStep = childBP.getChild();
			for (int j = 0; j < childListStep.size(); j++){
				CompositeComponent childStep = (CompositeComponent) childListStep.get(j);
				String chilStepValue = childStep.getPhrase().getSentence();
				Element childStepElement = childElement.getOwnerDocument().createElement("Step");
				Attr attrStepName = childElement.getOwnerDocument().createAttribute("value");
				attrStepName.setNodeValue(chilStepValue);
				childStepElement.getAttributes().setNamedItem(attrStepName);
				childElement.appendChild(childStepElement);
				List<RequirementComponent> childListAction = childStep.getChild();
				for (int k = 0; k < childListAction.size(); k++){
					CompositeComponent childAction = (CompositeComponent) childListStep.get(k);
					String childActionValue = childAction.getPhrase().getSentence();
					Element childActionElement = childStepElement.getOwnerDocument().createElement("Action");
					Attr attrActionName = childActionElement.getOwnerDocument().createAttribute("value");
					attrActionName.setNodeValue(childActionValue);
					childActionElement.getAttributes().setNamedItem(attrActionName);
					childStepElement.appendChild(childActionElement);
				}
			}
		}
	}
}


