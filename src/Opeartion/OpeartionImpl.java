package Opeartion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import compoiste.CompositeComponent;
import BusinessObjects.RequirementComponent;
import Commands.AddComponent;
import Commands.EditComponent;
import Commands.GetChild;
import Commands.GetComponent;
import Commands.ListCommand;
import Commands.RemoveComponent;

public class OpeartionImpl implements OpeartionInterface{

	private static CompositeComponent root;
	
	private Stack<ListCommand> executedStack = new Stack<ListCommand>();
    private Stack<ListCommand> undoneStack = new Stack<ListCommand>();
	
    public OpeartionImpl(){
    	root = new CompositeComponent(null);
    }
    
    @Override
    public boolean undo()
    {
        if (executedStack.size() > 0)
        {
        	ListCommand cmd = executedStack.pop();
            Object result = cmd.undoExecute();
            undoneStack.push(cmd); 
            
            return (boolean)result;
        }
        
        return false;
    }

    @Override
    public boolean redo()
    {
        if (undoneStack.size() > 0)
        {
        	ListCommand cmd = undoneStack.pop();
            Object result = cmd.execute();
            executedStack.push(cmd);
            return (boolean)result;
        }
        
        return false;
    }

	@Override
	public boolean addComponent(RequirementComponent parent,
			RequirementComponent child, int index) {
		
		ListCommand add = new AddComponent( parent,child, index);
		
		boolean result = (boolean)add.execute();
		
		if(result){
			executedStack.push(add);
		}
		
		return result;
	}

	@Override
	public boolean removeComponent(RequirementComponent child) {
		
		ListCommand remove = new RemoveComponent(child);
		
		boolean result = (boolean)remove.execute();
		
		if(result){
			executedStack.push(remove);
		}
		
		return result;
	}

	@Override
	public List<RequirementComponent> getChild(RequirementComponent parent) {
		
		ListCommand getChild = new GetChild(parent);
		
		return (List<RequirementComponent>)getChild.execute();
	}

	@Override
	public RequirementComponent getComponent(String id) {
		
		ListCommand getComponent =  new GetComponent(root, id);
		
		return (RequirementComponent) getComponent.execute();
	}

	@Override
	public boolean editComponent(RequirementComponent oldCom,
			RequirementComponent newCom, int newIndex) {

		ListCommand edit = new EditComponent( oldCom,newCom,  newIndex);
		
		boolean result = (boolean)edit.execute();
		
		if(result){
			executedStack.push(edit);
		}
		
		return result;
	}

	@Override
	public String generateRequirement() {

		return null;
	}

	@Override
	public boolean exportRequirement(String path) {
		
		return false;
	}
    
}
