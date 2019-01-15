package adapters;

import domain.AbstractId;
import domain.DeviceId;
import domain.IDescriptor;
import middleware.ILowObject;
import middleware.LowObject;

public class DescriptorAdapter implements IDescriptor {
	
	private ILowObject adaptee;
	
	private static final String id = "dal.device.UID";
	private static final String name = "dal.device.name";
	
	
	
	public DescriptorAdapter(ILowObject adaptee){
		this.adaptee = adaptee;
	}
	

	@Override
	public AbstractId getId() {
		return new DeviceId(this.adaptee.get(id).toString());
	}

	@Override
	public Object getDescription() {
		// TODO Auto-generated method stub
		return this.adaptee.get(name);
	}

}
