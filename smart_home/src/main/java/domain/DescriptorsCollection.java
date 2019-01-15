package domain;

import java.util.ArrayList;
import java.util.List;

public class DescriptorsCollection {
	private List <DeviceDescriptor> descriptorsCollection;
	
	// costruttore collezione 
	public DescriptorsCollection() {
		this.descriptorsCollection = new ArrayList<DeviceDescriptor>();
	}
	
	//contains 
	public boolean containsDeviceDescriptor(AbstractId id) {
		for (DeviceDescriptor object: this.descriptorsCollection) {
		    if (object.getId().equals(id))
		    	return true;  	
		}
		return false;
	}
	
	//remove
	public void removeDeviceDescriptor(AbstractId device) {
			for (DeviceDescriptor object: this.descriptorsCollection) {
			    if (object.getId().equals(device))
			    	this.descriptorsCollection.remove(object); 	
			}
		}
		
	//add
	public void addDeviceDescriptor(DeviceDescriptor device) {
		this.descriptorsCollection.add(device);
	}
	
	// linear search
	public DeviceDescriptor searchDeviceDescriptor(AbstractId device) {
		for (DeviceDescriptor object: this.descriptorsCollection) {
		    if (object.getId().equals(device))
		    	return object;
		}
		return null;
	}
	
	//size 
	public int size() {
		int cont=0;
		for (DeviceDescriptor object: this.descriptorsCollection) {
		    cont++;
		}
		return cont;
	}
	
	//print
	public void print() {
		for (DeviceDescriptor object: this.descriptorsCollection) {
		    System.out.println(object);
		}
	}
	
	
}
