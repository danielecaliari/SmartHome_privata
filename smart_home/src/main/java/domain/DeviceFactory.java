package domain;

public class DeviceFactory {
	
	private Device device;
	
	public DeviceFactory(DeviceDescriptor dd){
		this.device = new Device(dd);
	}
	
	
	//Per Ogni dato member da aggiungere si fa OVERLOAD di questo metodo e si ritorna sempre this
	
	public Device getDevice(){
		return this.device;
	}

}
