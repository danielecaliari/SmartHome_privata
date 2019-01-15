package smart_home.smart_home;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import domain.*;


public class Main {
	@SuppressWarnings("unchecked")
	public static void main(String args[]) throws Exception {
	DomainFacade api = new DomainFacade();
	api.scanDevice();
	
	//DeviceDescriptor desc = new DeviceDescriptor();
	//desc.setId((new DeviceId("ZigBee:ah.app.12345195726903800-1")));
	
	//api.addDevice(desc);
	
	//api.scanDevice();
		
	DescriptorsCollection dd = new DescriptorsCollection();
	dd = api.getDeviceDescriptors();
	System.out.println(dd.size());
	
	dd.print();
	
	//Collection<Device> devs = new ArrayList<Device>(api.getDevices());
	//System.out.println(devs.size());
	//System.out.println(devs);
	
	
	
	}
}	