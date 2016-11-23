package compoiste;

import BusinessObjects.Phrase;

public abstract class RequirementComponenet {

	private Phrase phrase;
	
	public void setPhrase(Phrase phrase){
		this.phrase = phrase;
	}
	
	public Phrase getPhrase(){
		return phrase;
	}
}
