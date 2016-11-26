package Controller;

import compoiste.CompositeComponent;
import compoiste.Phrase;

import BusinessObjects.Action;
import BusinessObjects.BusinessProcess;
import BusinessObjects.Repository;
import BusinessObjects.RequirementComponent;
import BusinessObjects.Step;
import Commands.EditComponent;
import Commands.RemoveComponent;
import Opeartion.OperationMgr;

public class EditBusinessProcessesController {

	public void removeRequirementComponent(RequirementComponent requirementComponent)
	{
		OperationMgr opManager = OperationMgr.getInstance();
		opManager.removeComponent(requirementComponent);
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

	public void editAction(Action oldAction, Step parent, String verb, String noun, String sentence, int position){

		Phrase phrase = new Phrase(verb, noun);

		if(sentence!=null && sentence.length()>0)
			phrase.setSentence(sentence);

		Action newAction = new Action(phrase);

		newAction.setParent(parent);

		EditComponent edit = new EditComponent(oldAction,newAction,position);
		edit.execute();
	}
}