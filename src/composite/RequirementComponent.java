package composite;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public abstract class RequirementComponent extends DefaultMutableTreeNode {

	//
	private RequirementComponent parent;	
	
	public RequirementComponent getParent() {
		return parent;
	}

	public void setParent(RequirementComponent parent) {
		this.parent = parent;
	}

	private Phrase phrase;
	
	public RequirementComponent(Phrase p) {
		this.phrase=phrase;
	}

	public void setPhrase(Phrase phrase){
		this.phrase = phrase;
	}
	
	public Phrase getPhrase(){
		return phrase;
	}
}
