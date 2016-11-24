package Commands;

import java.util.List;

import compoiste.CompositeComponent;

import BusinessObjects.RequirementComponent;

public class GetComponent extends ListCommand{

	private List<RequirementComponent> root;
	private int bpNum,stepNum,actionNum;
	
	public GetComponent(List<RequirementComponent> root, String id){
		String[] num = id.split(".");
    	
    	bpNum = Integer.parseInt(num[0]);
    	stepNum = Integer.parseInt(num[1]);
    	actionNum = Integer.parseInt(num[2]);
    	
	}
	
	@Override
	public Object execute() {
		
		RequirementComponent child = null;
		
		if(bpNum != -1){
			child = root.get(bpNum);
			
			if(stepNum != -1){
				child = ((CompositeComponent)child).getChildAt(stepNum);
				
				if(actionNum != -1){
					child = ((CompositeComponent)child).getChildAt(actionNum);
				}
			}
		
		}
		
		return child;
	}

	@Override
	public Object undoExecute() {
		return null;
	}

}
