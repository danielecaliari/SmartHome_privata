package domain;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SmartHome {

	/*Per ora ci serve solo la collezione di Device Descriptor*/
	DescriptorsCollection descriptorsCollection;
	Map<AbstractId,Device> devices;

	
	/*Questo rende la classe istanziabile una volta SOLA per tutto il sistema*/
	private static final SmartHome INSTANCE = new SmartHome();

	//Il Costruttore è privato per il singleton
	private SmartHome(){
		this.descriptorsCollection = new DescriptorsCollection();
		this.devices = new HashMap<AbstractId, Device>();
	};


	public static SmartHome getInstance(){
		return INSTANCE;
	}

	public DescriptorsCollection getDeviceDescriptors() { return this.descriptorsCollection; }

	public void createDeviceDescriptors(Collection<IDescriptor> descs) {
			for (IDescriptor element : descs)
				descriptorsCollection.add(DeviceDescriptor.DeviceDescriptorFactory.createDeviceDescriptor(element));
	}
	
								
	//void addDevice(Device d) { this.devices.put(new DeviceId(d.getDescriptor()), d);}
	
	Collection<Device> getDevices() { return this.devices.values(); }

}
