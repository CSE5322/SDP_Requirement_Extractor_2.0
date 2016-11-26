package Controller;

import java.util.List;

import compoiste.Phrase;

import BusinessObjects.Action;
import BusinessObjects.BusinessProcess;
import BusinessObjects.Repository;
import BusinessObjects.Step;
import Commands.EditComponent;
import Commands.GetChildList;
import Opeartion.OperationMgr;

public class GenerateRequirementController {
	
    public String generateRequirement(){
        
        return OperationMgr.getInstance().generateRequirement();
	}
}
