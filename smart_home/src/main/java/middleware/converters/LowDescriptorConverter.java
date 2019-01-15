package middleware.converters;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import domain.IDescriptor;
import middleware.ILowObject;
import middleware.LowObject;

public class LowDescriptorConverter implements IConverter {
	
	
	@Override
	 public Collection<? extends ILowObject> convert(File f) throws FileNotFoundException, IOException, ParseException{
		return this.convertToLowObjectCollection(new Parser().parseJSONFile(f));
	 }
	

public Collection<? extends ILowObject> convertToLowObjectCollection(JSONObject jo) throws FileNotFoundException, IOException, ParseException, org.json.simple.parser.ParseException {
 		
		List<ILowObject> lowObjectDescriptorCollection = new ArrayList<ILowObject>();  
        JSONArray ja = (JSONArray) jo.get("result");
        
        LowDescriptorAdapter adapter = new LowDescriptorAdapter();
        
        for (Object element : ja) {
        	adapter.setToAdapt((JSONObject) element); 	
            lowObjectDescriptorCollection.add(adapter.convertToLowObject());
        }
        return lowObjectDescriptorCollection;
        
	}



	



}
