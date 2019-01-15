package domain;

import java.util.List;

public class Device extends AbstractDevice {
	
	
	List <IFunction> functions;
	
	// costruttore di device..solo una parte manca la parte di funzioni
	public Device(DeviceDescriptor deviceDescriptor) {
		super.setDescriptor(deviceDescriptor);
	}
	
	
	public void setDescriptor(IDescriptor desc) {
		super.setDescriptor(desc);
	}

	@Override
	public IDescriptor getDescriptor() {
		
		return super.descriptor;
	}


}
