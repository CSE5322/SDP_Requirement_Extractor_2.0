package Commands;

import java.util.List;

import compoiste.CompositeComponent;


import BusinessObjects.RequirementComponent;


public class GetChildList extends ListCommand{
	RequirementComponent parent;
	
	public GetChildList(RequirementComponent parent) {
		this.parent=parent;
	}
	
	
	@Override
	public Object execute()
	{
		if(parent instanceof CompositeComponent){
			return ((CompositeComponent)parent).getChild();
		}
		
		return null;
	}


	@Override
	public Object undoExecute() {
		return null;
	}
}
