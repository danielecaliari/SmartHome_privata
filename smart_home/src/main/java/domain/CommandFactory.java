package domain;

public class CommandFactory {
	
	ICommand concreteCommand;
	
	
	public ICommand createCommand(Tag t, Object id){
		if(t.toString().equals("dal.function.property.names"))
			this.concreteCommand = new Operation(t,id);
		else
			this.concreteCommand = new Property(t,id);
		return this.concreteCommand;
	}
	

}
