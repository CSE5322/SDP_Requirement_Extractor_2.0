package Controller;



import Commands.EditComponent;
import Commands.RemoveComponent;
import Opeartion.OperationMgr;
import composite.CompositeComponent;
import composite.Phrase;
import composite.PrimitiveComponent;
import composite.RequirementComponent;

public class EditBusinessProcessesController {

	public void removeRequirementComponent(String removedComponenet)
	{
		OperationMgr opManager = OperationMgr.getInstance();
		CompositeComponent oldBpComponent = (CompositeComponent) opManager.getComponent(removedComponenet);
		
		
		opManager.removeComponent(oldBpComponent);
	}

	public void editBusinessProcess(String oldBpId,String verb, String noun, String sentence, int position){

		Phrase phrase = new Phrase(verb, noun);

		if(sentence!=null && sentence.length()>0)
			phrase.setSentence(sentence);		

		CompositeComponent newBpComponent = new CompositeComponent(phrase);
		OperationMgr opManager = OperationMgr.getInstance();
		CompositeComponent oldBpComponent = (CompositeComponent) opManager.getComponent(oldBpId);
		newBpComponent.setChild(oldBpComponent.getChild());
		opManager.editComponent(oldBpComponent, newBpComponent, position);

	}

	public void editStep(String oldStepId, String parentId, String verb, String noun, String sentence, int position){
		
		Phrase phrase = new Phrase(verb, noun);

		if(sentence!=null && sentence.length()>0)
			phrase.setSentence(sentence);
		
		CompositeComponent newStepComponent = new CompositeComponent(phrase);		
		OperationMgr opManager = OperationMgr.getInstance();
		CompositeComponent oldStepComponent = (CompositeComponent) opManager.getComponent(oldStepId);
		CompositeComponent parent = (CompositeComponent) opManager.getComponent(parentId);
		newStepComponent.setChild(oldStepComponent.getChild());
		newStepComponent.setParent(parent);
		opManager.editComponent(oldStepComponent, newStepComponent, position);

	}

	public void editAction(String oldActionId, String parentId, String verb, String noun, String sentence, int position){

		Phrase phrase = new Phrase(verb, noun);

		if(sentence!=null && sentence.length()>0)
			phrase.setSentence(sentence);

		PrimitiveComponent newActionComponent = new PrimitiveComponent(phrase);		
		OperationMgr opManager = OperationMgr.getInstance();
		PrimitiveComponent oldActionComponent = (PrimitiveComponent) opManager.getComponent(oldActionId);
		CompositeComponent parent = (CompositeComponent) opManager.getComponent(parentId);
		newActionComponent.setParent(parent);
		opManager.editComponent(oldActionComponent, newActionComponent, position);
		
	}
}