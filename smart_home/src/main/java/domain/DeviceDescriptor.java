package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class DeviceDescriptor implements IDescriptor{
	
	Map<Tag,Object> descriptorElements = new HashMap<>();
	
	
	private DeviceDescriptor (DeviceId id) {
		//this.setId(id);
	}
	
	public DeviceDescriptor() {
		// TODO Auto-generated constructor stub
	}
	
	public void addElement(Tag t, Object value){
		this.descriptorElements.put(t, value);
	}
	
	

	/** SETTERS
	 * @param id the id to set
	 
	public void setId(DeviceId id) {
		//this.id = id;
		this.descriptorElements.put(new Tag("UID"), id);
		//System.out.println(this.descriptorElements.get(new Tag("UID")));
	}

	/**
	 * @param description the description to set
	 
	private void setName(Object name) {
		this.descriptorElements.put(new Tag("name"), name);
	}
*/
	
	/** GETTERS
	 * @return the id
	 */
	public DeviceId getId() {
		
		return new DeviceId(this.lookForAParameter("UID").toString());
	}
	
	
	
	/**
	 * @return the description
	 */
	public String getDeviceName() {
		return this.lookForAParameter("name").toString();
	}
	
	

	@Override
	public Object lookForAParameter(String param) {
		
		//Con questo metodo come in LowObject cerchi una corrispondenza parziale
		//COn le Espressioni regolari
		Pattern p = Pattern.compile(param);
		for(Tag t : this.descriptorElements.keySet())
			   if(p.matcher(t.toString()).find())
				   return this.descriptorElements.get(t);
		return null;
	}


 public String toString(){
	 return this.descriptorElements.toString();
 }
 	
 	
 

static class DeviceDescriptorFactory{
			
		public static DeviceDescriptor createDeviceDescriptor(IDescriptor lowObject)
			{
			DeviceDescriptor deviceDescriptor = new DeviceDescriptor();
			deviceDescriptor.initializeDescriptor(lowObject);
			return deviceDescriptor;
			}
			
		}

public void initializeDescriptor(IDescriptor abstractDesc) {
	Set<Tag> tags = abstractDesc.getDescriptorParameters();
	for(Tag t : tags)
		this.descriptorElements.put(t, abstractDesc.lookForAParameter(t.toString()));
}


public Set<Tag> getDescriptorParameters() {
	
	return this.descriptorElements.keySet();
}


}
