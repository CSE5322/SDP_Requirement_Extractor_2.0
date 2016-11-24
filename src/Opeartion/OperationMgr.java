package Opeartion;

import java.util.List;

import compoiste.CompositeComponent;
import compoiste.Phrase;
import BusinessObjects.RequirementComponent;

public class OperationMgr {

	private OperationMgr instance;
	private OpeartionInterface operation;
	
	public OperationMgr getInstance(){
		if(instance == null)
			instance = new OperationMgr();
		
		return instance;
	}
	
	private OperationMgr(){
		operation = new OpeartionImpl();
	}
	
	public boolean addComponent(RequirementComponent parent,RequirementComponent child,int index){
		 return operation.addComponent(parent, child, index);
	}
	
	public boolean removeComponent(RequirementComponent child){
		return operation.removeComponent(child);
	}
	
	public List<RequirementComponent> getChild(RequirementComponent parent){
		return operation.getChild(parent);
	}
	
	public RequirementComponent getComponent(String id){
		return operation.getComponent(id);
	}
	
	public boolean editComponent(RequirementComponent oldCom,RequirementComponent newCom,int newIndex){
		return operation.editComponent(oldCom, newCom, newIndex);
	}
	
	public String generateRequirement(){
		return operation.generateRequirement();
	}
	
	public boolean exportRequirement(String path){
		return operation.exportRequirement(path);
	}
	
	public boolean undo(){
		return operation.undo();
	}
	
	public boolean redo(){
		return operation.redo();
	}
}
