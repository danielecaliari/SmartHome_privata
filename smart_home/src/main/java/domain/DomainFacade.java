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
	
	
	public void addDevice(Object id){
		if(this.home.getDeviceDescriptors().contains(id)){
			
			//TODO eliminare dalla lista il descriptor trovato
			
			DeviceFactory df = new DeviceFactory(//descrittore ottenuto dalla ricerca);
					
			
		}
	}


	public Collection<Device> getDevices() {
		// TODO Auto-generated method stub
		return this.home.getDevices();
	}


}
