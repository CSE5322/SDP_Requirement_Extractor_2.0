package composite;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;


public class CompositeComponent extends RequirementComponent{

	private String type;
	private List<RequirementComponent> childList;
	private int priority;
	
	public CompositeComponent(Phrase p) {
		super(p);
		childList = new ArrayList<>();
	}

	public void setType(String type){
		this.type = type;
	}
	
	public String getType(){
		return type;
	}
	
	public void setPriority(int priority){
		this.priority = priority;
	}
	
	public int getPriority(){
		return priority;
	}
	
	public void addChildAt(int index, RequirementComponent child){
		childList.add(index,child);
	}
	
	public void setChild(List<RequirementComponent> childList){
		this.childList = childList;
	}
	
	public List<RequirementComponent> getChild(){
		return childList;
	}
	
	public RequirementComponent getChildObjAt(int index){
		
		if(index < childList.size())
			return childList.get(index);
		else
			return null;
	}
	
	public TreeNode getChildAt(int index) {
        if (childList == null) {
            throw new ArrayIndexOutOfBoundsException("node has no children");
        }
        return (TreeNode)childList.get(index);
    }

/**
 * Returns the number of children of this node.
 *
 * @return  an int giving the number of children of this node
 */
public int getChildCount() {
    if (childList == null) {
        return 0;
    } else {
        return childList.size();
    }
}
}
