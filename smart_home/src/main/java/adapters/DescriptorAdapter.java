package adapters;

import java.util.HashSet;
import java.util.Set;

import domain.AbstractId;
import domain.DeviceId;
import domain.IDescriptor;
import domain.Tag;
import middleware.ILowObject;
import middleware.LowObject;

public class DescriptorAdapter implements IDescriptor {
	
	private ILowObject adaptee;
	
	private static final String id = "UID";
	private static final String name = "name";
	
	
	
	public DescriptorAdapter(ILowObject adaptee){
		this.adaptee = adaptee;
	}
	

	@Override
	public AbstractId getId() {
		return new DeviceId(this.adaptee.get(id).toString());
	}


	@Override
	public Object lookForAParameter(String param) {
		System.out.println(param);
		System.out.println(this.adaptee.get(param));
		return this.adaptee.get(param);
	}


	@Override
	public Set<Tag> getDescriptorParameters() {
		Set<Tag> tagsForDescriptor = new HashSet<>();
		
		for (String key : this.adaptee.getKeys())
			tagsForDescriptor.add(new Tag(key));
		
		return tagsForDescriptor;
	}

}
