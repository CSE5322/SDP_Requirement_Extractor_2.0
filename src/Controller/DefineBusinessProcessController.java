package Controller;

import java.awt.Color;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.tree.DefaultTreeModel;

import Commands.AddComponent;
import Commands.GetChildList;
import Commands.RemoveComponent;
import Opeartion.OperationMgr;
import composite.CompositeComponent;
import composite.Phrase;
import composite.PrimitiveComponent;
import composite.RequirementComponent;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;


public class DefineBusinessProcessController {
	
	//Variables for Stanfor NLP
	static String modelFile;
	static MaxentTagger tagger;	
	static DefaultTreeModel treeModel;
	
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
	
	public void setTreeModel(DefaultTreeModel _treeModel){
		treeModel = _treeModel;
	}
	
	public DefaultTreeModel getCompleteModel(){
		return treeModel;
	}
	
	public List<String> getSteps(String bpID){

		String[] num =bpID.split("\\.");
		List<String> stepList=new ArrayList<String>();
		OperationMgr opn= OperationMgr.getInstance();
		
		
		List<RequirementComponent> StepList=opn.getChildList(opn.getComponent(bpID));
		
		
		for (int i = 0; i < StepList.size(); i++) {
			
			stepList.add(num[0]+"."+i+".-1");
		
		}
		
		return stepList;
		
		
		
	}
	
	
	
	public List<String> getActions(String step){


		String[] num =step.split("\\.");
		List<String> stepList=new ArrayList<String>();
		OperationMgr opn= OperationMgr.getInstance();
		
		
		List<RequirementComponent> StepList=opn.getChildList(opn.getComponent(step));
		
		
		for (int i = 0; i < StepList.size(); i++) {
			
			stepList.add(num[0]+"."+num[1]+"."+i);
		
		}
		
		return stepList;
		
		
		
	}
	
	  public String[] getComponentPhraseInfo(String componentId)
	    {
	       OperationMgr opn= OperationMgr.getInstance();
	       Phrase phrase = opn.getComponent(componentId).getPhrase();
	       String[] phraseInfo = new String[3];
	       if(phrase!=null)
	       {
	             phraseInfo[0] = phrase.getVerb();
	             phraseInfo[1] = phrase.getNoun();
	             phraseInfo[2] = phrase.getSentence();
	       }
	       return phraseInfo;
	    }

	public void addCompositeComponent(String verb, String noun, String sentence, int position,String parentID){
		
		Phrase phrase = new Phrase(verb, noun);
		
		if(sentence!=null && sentence.length()>0)
			phrase.setSentence(sentence);
		
		RequirementComponent compositeComponent = new CompositeComponent(phrase);
		
		OperationMgr opn= OperationMgr.getInstance();
		
		opn.addComponent(opn.getComponent(parentID), compositeComponent, position);
		
		
	}
	

    
    public void addPrimitiveComponent(String verb, String noun, String sentence, String parentID ,int position){
		
		Phrase phrase = new Phrase(verb, noun);
		
		if(sentence!=null && sentence.length()>0)
			phrase.setSentence(sentence);
		
		RequirementComponent businessProcess = new PrimitiveComponent(phrase);
		
		OperationMgr opn= OperationMgr.getInstance();
		
		opn.addComponent(opn.getComponent(parentID), businessProcess, position);
		
		
	}
    
	public static void initializeAutoHighlighter()
	{
		modelFile = "model\\english-bidirectional-distsim.tagger";
		tagger = new MaxentTagger(modelFile);
	}
	
	public static void autoHighlight(String text, Highlighter highlighter)
	{
		StringReader stringReader = new StringReader(text);

		List<List<HasWord>> sentences = MaxentTagger.tokenizeText(stringReader);			    

		try
		{
			for (List<HasWord> sentence : sentences) 
			{
				List<TaggedWord> tSentence = tagger.tagSentence(sentence);  
				for(TaggedWord tword : tSentence) 
				{
					if(tword.value().equals("-RRB-") || tword.value().equals("-LRB-"))
						continue;

					if(tword.tag().equals("VBG") || tword.tag().equals("VBZ"))   //VBZ VBP
						highlighter.addHighlight(tword.beginPosition(), tword.endPosition(), new DefaultHighlighter.DefaultHighlightPainter(Color.yellow));
					else if(tword.tag().equals("NN"))
						highlighter.addHighlight(tword.beginPosition(), tword.endPosition(),new DefaultHighlighter.DefaultHighlightPainter(Color.green));
				}			      
			}
		}catch(BadLocationException ex)
		{
			ex.printStackTrace();
		}
	}

    
}
