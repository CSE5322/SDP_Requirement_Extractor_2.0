package Commands;

import java.util.List;

import compoiste.CompositeComponent;

import BusinessObjects.Action;
import BusinessObjects.BusinessProcess;
import BusinessObjects.Repository;
import BusinessObjects.RequirementComponent;
import BusinessObjects.Step;

public class GetChild extends ListCommand{
	RequirementComponent parent;
	
	public GetChild(RequirementComponent parent) {
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
