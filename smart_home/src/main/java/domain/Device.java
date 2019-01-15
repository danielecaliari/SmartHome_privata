package domain;

import java.util.List;

public class Device extends AbstractDevice {
	
	List <IFunction> functions;
	public void setDescriptor(IDescriptor desc) {
		super.setDescriptor(desc);
	}

	@Override
	public IDescriptor getDescriptor() {
		
		return super.descriptor;
	}


}
