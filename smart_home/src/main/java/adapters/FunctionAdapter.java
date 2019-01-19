package adapters;


import java.util.ArrayList;
import java.util.Collection;

import domain.AbstractId;
import domain.CommandFactory;
import domain.ICommand;
import domain.IFunction;
import middleware.ILowObject;
import middleware.LowObject;

public class FunctionAdapter implements IFunction {
	
	ILowObject adaptee;
	
	
	
	public FunctionAdapter(ILowObject obj){
		this.adaptee = obj;
	}
	
	private LowObject findTag(String param){
		return this.adaptee.gett(param);
	}

	@Override
	public AbstractId getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<ICommand> getCommands() {
		Collection<ICommand> res = new ArrayList<>();
		CommandFactory fact = new CommandFactory();
		LowObject opArray = this.findTag("operation");
		
		if(opArray != null){
			fact.createCommand("operation", )
			}
			
		//System.out.println(opArray.toString());
		
		return res;
	}

}
