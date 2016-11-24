package Opeartion;

import java.util.List;

import BusinessObjects.Phrase;
import BusinessObjects.RequirementComponent;
import compoiste.CompositeComponent;

public interface OpeartionInterface {

	public boolean addComponent(RequirementComponent parent,RequirementComponent child,int index);
	public boolean removeComponent(RequirementComponent child);
	public List<RequirementComponent> getChild(RequirementComponent parent);
	public RequirementComponent getComponent(String id);
	
	public boolean editComponent(
			RequirementComponent oldCom,
			RequirementComponent newCom,
			int newIndex);
	
	public String generateRequirement();
	public boolean exportRequirement(String path);
	
	public boolean undo();
	public boolean redo();
}
