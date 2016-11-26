package Opeartion;

import java.util.List;

import BusinessObjects.RequirementComponent;
import compoiste.CompositeComponent;
import compoiste.Phrase;

public interface OpeartionInterface {

	public boolean addComponent(RequirementComponent parent,RequirementComponent child,int index);
	public boolean removeComponent(RequirementComponent child);
	public List<RequirementComponent> getChildList(RequirementComponent parent);
	public RequirementComponent getComponent(String id);
	
	public boolean editComponent(
			RequirementComponent oldCom,
			RequirementComponent newCom,
			int newIndex);
	
	public String generateRequirement();
	public boolean exportRequirement(String requirement, String path, String extension);
	
	public boolean undo();
	public boolean redo();
}
