package Opeartion;

import java.util.List;

import compoiste.CompositeComponent;
import BusinessObjects.Phrase;
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
	
	public boolean addComponent(CompositeComponent parent,Phrase phrase, int index){
		
		return true;
	}
	
	public List<RequirementComponent> getComponent(){
		return null;
	}
	
	public boolean editComponent(){
		return true;
	}
	
	public String generateRequirement(){
		return "";
	}
	
	public boolean exportRequirement(){
		return true;
	}
}
