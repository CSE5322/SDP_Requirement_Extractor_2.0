package Opeartion;

public class OperationMgr {

	private OperationMgr instance;
	
	public OperationMgr getInstance(){
		if(instance == null)
			instance = new OperationMgr();
		
		return instance;
	}
	
	private OperationMgr(){
		
	}
}
