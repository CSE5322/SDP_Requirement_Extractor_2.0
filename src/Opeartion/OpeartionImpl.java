package Opeartion;

import java.util.List;
import java.util.Stack;

import BusinessObjects.RequirementComponent;
import Commands.ListCommand;

public class OpeartionImpl implements OpeartionInterface{

	private Stack<ListCommand> commandUndoStack = new Stack<ListCommand>();
    private Stack<ListCommand> commandRedoStack = new Stack<ListCommand>();
	
    @Override
    public boolean undo()
    {
        if (commandUndoStack.size() > 0)
        {
        	ListCommand cmd = commandUndoStack.pop();
            //Object result = cmd.undoExecute();
            commandRedoStack.push(cmd); 
            
            return true;
        }
        
        return false;
    }

    @Override
    public boolean redo()
    {
        if (commandRedoStack.size() > 0)
        {
        	ListCommand cmd = commandRedoStack.pop();
            //Object result = cmd.execute();
            commandUndoStack.push(cmd);
            return true;
        }
        
        return false;
    }
    
	@Override
	public boolean addComponent(RequirementComponent parent,
			RequirementComponent child, int index) {
		
		return false;
	}

	@Override
	public List<RequirementComponent> getComponent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean editComponent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String generateRequirement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exportRequirement() {
		// TODO Auto-generated method stub
		return false;
	}
}
