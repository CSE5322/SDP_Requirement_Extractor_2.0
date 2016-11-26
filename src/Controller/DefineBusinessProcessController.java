package Controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.DefaultTreeModel;

import Commands.AddComponent;
import Commands.GetChildList;
import Commands.RemoveComponent;
import Opeartion.OperationMgr;
import composite.CompositeComponent;
import composite.Phrase;
import composite.PrimitiveComponent;
import composite.RequirementComponent;


public class DefineBusinessProcessController {
	
	public List<String> getBusinessProcesses(){
		
		List<String> bPList=new ArrayList<String>();
		OperationMgr opn= OperationMgr.getInstance();
		
		
		List<RequirementComponent> BpList=opn.getChildList(opn.getComponent("-1.-1.-1"));
		
		
		for (int i = 0; i < BpList.size(); i++) {
			
			bPList.add(i+".-1.-1");
		
		}
		
		return bPList;
		
		
	}
	
	public DefaultTreeModel getTreeModel()
	{
		OperationMgr opn= OperationMgr.getInstance();
		
		
		
		return new DefaultTreeModel(opn.getComponent("-1.-1.-1"));
		
	}
	
	public List<String> getSteps(String bpID){

		String[] num =bpID.split(".");
		List<String> stepList=new ArrayList<String>();
		OperationMgr opn= OperationMgr.getInstance();
		
		
		List<RequirementComponent> StepList=opn.getChildList(opn.getComponent(bpID));
		
		
		for (int i = 0; i < StepList.size(); i++) {
			
			stepList.add(num[0]+"."+i+".-1");
		
		}
		
		return stepList;
		
		
		
	}
	
	
	
	public List<String> getActions(String step){


		String[] num =step.split(".");
		List<String> stepList=new ArrayList<String>();
		OperationMgr opn= OperationMgr.getInstance();
		
		
		List<RequirementComponent> StepList=opn.getChildList(opn.getComponent(step));
		
		
		for (int i = 0; i < StepList.size(); i++) {
			
			stepList.add(num[0]+"."+num[1]+"."+i);
		
		}
		
		return stepList;
		
		
		
	}

	public void addCompositeComponent(String verb, String noun, String sentence, int position,String parentID){
		
		Phrase phrase = new Phrase(verb, noun);
		
		if(sentence!=null && sentence.length()>0)
			phrase.setSentence(sentence);
		
		RequirementComponent businessProcess = new CompositeComponent(phrase);
		
		OperationMgr opn= OperationMgr.getInstance();
		
		opn.addComponent(opn.getComponent(parentID), businessProcess, position);
		
		
	}
	

    
    public void addPrimitiveComponent(String verb, String noun, String sentence, String parentID ,int position){
		
		Phrase phrase = new Phrase(verb, noun);
		
		if(sentence!=null && sentence.length()>0)
			phrase.setSentence(sentence);
		
		RequirementComponent businessProcess = new PrimitiveComponent(phrase);
		
		OperationMgr opn= OperationMgr.getInstance();
		
		opn.addComponent(opn.getComponent(parentID), businessProcess, position);
		
		
	}
    
    
}