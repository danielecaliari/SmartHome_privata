package domain;



public class DeviceDescriptor implements IDescriptor{
	private DeviceId id;
	private DeviceDescription description;
	
	
	private DeviceDescriptor (DeviceId id, DeviceDescription description) {
		this.setId(id);
		this.setDescription(description);
	}
	
	public DeviceDescriptor() {
		// TODO Auto-generated constructor stub
	}

	/** SETTERS
	 * @param id the id to set
	 */
	public void setId(DeviceId id) {
		this.id = id;
	}

	/**
	 * @param description the description to set
	 */
	private void setDescription(DeviceDescription description) {
		this.description = description;
	}

	
	/** GETTERS
	 * @return the id
	 */
	public DeviceId getId() {
		return id;
	}
	
	
	
	/**
	 * @return the description
	 */
	public DeviceDescription getDescription() {
		return description;
	}
	
	
	
 @Override
	public String toString() {
		return "DeviceDescriptor [id=" + id + ", description=" + description + "]";
	}



static class DeviceDescriptorFactory{
			
		public static DeviceDescriptor createDeviceDescriptor(IDescriptor lowObject)
			{
			DeviceDescriptor deviceDescriptor= new DeviceDescriptor(new DeviceId(lowObject.getId().toString()),
					new DeviceDescription(lowObject.getDescription().toString()));
			return deviceDescriptor;
			}
			
		}



@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	DeviceDescriptor other = (DeviceDescriptor) obj;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}


public String getStringId() {
	return this.id.toString();
}

}
