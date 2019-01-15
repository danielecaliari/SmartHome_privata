package domain;

public abstract class AbstractDevice implements IDevice {
	
	protected IDescriptor descriptor;
	

	@Override
	public void executeOperation() {
		// TODO Auto-generated method stub
	}
	
	public void setDescriptor(IDescriptor desc){
		this.descriptor = desc;
	}

}
