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
	
	int oldIndex;
	int newIndex;

	public EditComponent(
			RequirementComponent oldCom,
			RequirementComponent newCom,
			int newIndex) {
		this.newCom = newCom;
		this.oldCom = oldCom;
		this.newIndex = newIndex;
		this.oldIndex = oldCom.getParent().getIndex(oldCom);
	}

	@Override
	public Object execute() {

		RemoveComponent remove = new RemoveComponent(oldCom);
		remove.execute();

		AddComponent add = null;

		add = new AddComponent(newCom.getParent(), newCom,
				newIndex);

		return add.execute();
	}
	
	@Override
	public Object undoExecute() {

		RemoveComponent remove = new RemoveComponent(newCom);
		remove.execute();

		AddComponent add = null;

		add = new AddComponent(oldCom.getParent(), oldCom,
				oldIndex);

		return add.execute();
	}

}