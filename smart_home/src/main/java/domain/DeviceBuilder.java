package domain;

public class DeviceBuilder {
	
	private Device device;
	
	public DeviceBuilder(){
		this.device = new Device();
	}
	
	//Fluent Builder
	public DeviceBuilder addChild(IDescriptor desc){
		this.device.setDescriptor(desc);
		return this;
	}
	
	//Per Ogni dato member da aggiungere si fa OVERLOAD di questo metodo e si ritorna sempre this
	
	public Device getDevice(){
		return this.device;
	}

}
