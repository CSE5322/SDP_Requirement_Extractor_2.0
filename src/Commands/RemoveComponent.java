package Commands;

import compoiste.CompositeComponent;

import BusinessObjects.Action;
import BusinessObjects.BusinessProcess;
import BusinessObjects.Repository;
import BusinessObjects.RequirementComponent;
import BusinessObjects.Step;

public class RemoveComponent extends ListCommand{
	
	RequirementComponent parent;
	RequirementComponent child;
	int index;
	
	public RemoveComponent(RequirementComponent parent, RequirementComponent child) {
		this.child=child;
		this.parent = parent;
	}
	
	
	@Override
	public Object execute()
	{
		
		if(parent instanceof CompositeComponent){
			int index = ((CompositeComponent)parent).getChild().indexOf(child);
			
			if(index == -1){
				return false;
			}
			
			this.index = index;
			
			((CompositeComponent)parent).remove(index);
			
			return true;
		}

		return false;
	}


	@Override
	public Object undoExecute() {
		
		ListCommand add = new AddComponent(parent, child, index);
		
		return add.execute();
	}

}