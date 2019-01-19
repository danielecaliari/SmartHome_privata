package middleware;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.json.simple.parser.ParseException;

import adapters.DescriptorAdapter;
import adapters.FunctionAdapter;
import domain.ICommand;
import domain.IDescriptor;
import domain.IFunction;
import middleware.converters.IConverter;
import middleware.converters.Converter;



public class MiddlewareFacade implements IMiddlewareFacade {
	
	ICache cache = new FileCache();
	
	
	@Override
	public Collection<IDescriptor> getDevices() 
			throws FileNotFoundException, IOException, ParseException, Exception {
		RestClient client = new RestClient();
		File jsonFile = client.get();
		this.cache.isInCache(jsonFile);
		IConverter converter = new Converter();
		Collection<ILowObject> lowDesc = converter.convert(jsonFile,"device");
		
		return this.getDescriptors(lowDesc);
	}
	
	
	private Collection<IDescriptor> getDescriptors(Collection<ILowObject> lowDesc) {
		List<IDescriptor> adapters = new ArrayList<IDescriptor>();
		for(ILowObject low : lowDesc)
			adapters.add(new DescriptorAdapter(low));
		
		return adapters;
	}
	
	
	
	public Collection<IFunction> getADeviceFunctions(IDescriptor desc) 
			throws FileNotFoundException, IOException, ParseException{
		RestClient client = new RestClient();
		File jsonFile = client.get(desc);
		IConverter converter = new Converter();
		Collection<ILowObject> lowObj = converter.convert(jsonFile,"function");
		this.getFunctions(lowObj);
		System.out.println(lowObj.size());
		System.out.println("RECEIVED FUNCTIONS!!!!!!!!!");
		return null;
	}
	
	
	
	private Collection<IFunction> getFunctions(Collection<ILowObject> lowFuncts){
		List<IFunction> adapters = new ArrayList<>();
		for(ILowObject low : lowFuncts){
			/*adapters.add*/ Collection<ICommand> test = (new FunctionAdapter(low).getCommands());
			
		}
		
		return adapters;
		}
	


}
