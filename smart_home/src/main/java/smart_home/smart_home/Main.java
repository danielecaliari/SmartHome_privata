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
	api.scanDevices();
		
	List<DeviceDescriptor> dd = new ArrayList<DeviceDescriptor>();
	dd = api.getDeviceDescriptors();
	System.out.println(dd.size());
	
	for(DeviceDescriptor ddd : dd){
		System.out.println(ddd.getId());
		System.out.println(ddd.getDeviceName());
		//System.out.println(ddd.lookForAParameter("stat").toString());
		System.out.println(ddd.getDescriptorParameters());
		//System.out.println(ddd);
	
	}
	
	api.addDevice(dd.get(3));
	
	
	
	//Collection<Device> devs = new ArrayList<Device>(api.getDevices());
	//System.out.println(devs.size());
	//System.out.println(devs);
	
	
	
	}
}	