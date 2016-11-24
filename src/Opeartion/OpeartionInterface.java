package Opeartion;

import java.util.List;

import BusinessObjects.Phrase;
import BusinessObjects.RequirementComponent;
import compoiste.CompositeComponent;

public interface OpeartionInterface {

	public boolean addComponent(RequirementComponent parent,RequirementComponent child, int index);
	public List<RequirementComponent> getComponent();
	public boolean editComponent();
	public String generateRequirement();
	public boolean exportRequirement();
	public boolean undo();
	public boolean redo();
}
