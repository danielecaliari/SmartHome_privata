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
	public void scanDevices() throws FileNotFoundException, IOException, ParseException, Exception {	
		Collection<IDescriptor> descs = middlewareFacade.getDevices();
		this.home.createDeviceDescriptors(descs);
	}
	
	
	public List<DeviceDescriptor> getDeviceDescriptors() { return this.home.getDeviceDescriptors(); }
	
	
	public void addDevice(Object id){
		if(this.home.getDeviceDescriptors().contains(id)){
			//System.out.println("COntains!");
			DeviceBuilder dvb = new DeviceBuilder();
			dvb.addChild(this.home.getDeviceDescriptors().get(0));
			//this.home.addDevice(dvb.getDevice());
		}
	}


	public Collection<Device> getDevices() {
		// TODO Auto-generated method stub
		return this.home.getDevices();
	}


}
