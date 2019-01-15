package domain;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.json.simple.parser.ParseException;

import middleware.IMiddlewareFacade;
import middleware.MiddlewareFacade;

public class DomainFacade implements IDomainFacade {
	
	private SmartHome home;
	
	/*Deve poter chiamare la facade di Middleware*/
	private IMiddlewareFacade middlewareFacade;
	
	
	public DomainFacade(){
		this.middlewareFacade = new MiddlewareFacade();
		this.home = SmartHome.getInstance();
		
	}
	

	@Override
	public void scanDevice() throws FileNotFoundException, IOException, ParseException, Exception {	
		Collection<IDescriptor> descs = middlewareFacade.getDevices();
		this.home.createDeviceDescriptors(descs);
	}
	
	
	public DescriptorsCollection getDeviceDescriptors() { return this.home.getDeviceDescriptors(); }
	
	
	public void addDevice(AbstractId id){
		if(this.home.getDeviceDescriptors().containsDeviceDescriptor(id)){
			
			// elimino il deviceDescriptor corrispondente all'id
			DeviceDescriptor deviceDescriptor = this.home.getDeviceDescriptors().searchDeviceDescriptor(id);
			this.home.getDeviceDescriptors().removeDeviceDescriptor(id);
			
			DeviceFactory df = new DeviceFactory(deviceDescriptor);
					
		}
	}


	public Collection<Device> getDevices() {
		// TODO Auto-generated method stub
		return this.home.getDevices();
	}


}
