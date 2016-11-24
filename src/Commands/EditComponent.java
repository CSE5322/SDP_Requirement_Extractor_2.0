package Commands;

import org.omg.CORBA.RepositoryIdHelper;

import BusinessObjects.Action;
import BusinessObjects.BusinessProcess;
import BusinessObjects.Repository;
import BusinessObjects.RequirementComponent;
import BusinessObjects.Step;

public class EditComponent extends ListCommand {
	RequirementComponent oldCom;
	RequirementComponent newCom;
	
	RequirementComponent oldParent;
	RequirementComponent newParent;
	
	int oldIndex;
	int newIndex;

	public EditComponent(
			RequirementComponent oldCom,
			RequirementComponent newCom,
			RequirementComponent oldParent,
			RequirementComponent newParent,
			int oldIndex,int newIndex) {
		this.newCom = newCom;
		this.oldCom = oldCom;
		this.oldParent = oldParent;
		this.newParent = newParent;
		this.oldIndex = oldIndex;
		this.newIndex = newIndex;
	}

	@Override
	public Object execute() {

		RemoveComponent remove = new RemoveComponent(oldParent,oldCom);
		remove.execute();

		AddComponent add = null;

		add = new AddComponent(newParent, newCom,
				newIndex);

		return add.execute();
	}
	
	@Override
	public Object undoExecute() {

		RemoveComponent remove = new RemoveComponent(newParent,newCom);
		remove.execute();

		AddComponent add = null;

		add = new AddComponent(oldParent, oldCom,
				oldIndex);

		return add.execute();
	}

}