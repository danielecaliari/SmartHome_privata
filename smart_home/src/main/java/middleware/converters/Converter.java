package middleware.converters;

import java.io.File;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.json.simple.parser.ParseException;


import middleware.ILowObject;


public class Converter implements IConverter {
	
	
	@Override
	 public Collection<? extends ILowObject> convert(File f) throws FileNotFoundException, IOException, ParseException{
		return this.convertToLowObjectCollection(new Parser().parseJSONFile(f));
	 }
	

public Collection<? extends ILowObject> convertToLowObjectCollection(JSONObject jo) throws FileNotFoundException, IOException, ParseException, org.json.simple.parser.ParseException {
 		
		List<ILowObject> lowObjectDescriptorCollection = new ArrayList<ILowObject>();  
        JSONArray ja = (JSONArray) jo.get("result");
        
        LowObjectCreator creator = new LowObjectCreator();
        
        for (Object element : ja) {
        	creator.setToAdapt((JSONObject) element); 	
            lowObjectDescriptorCollection.add(creator.convertToLowObject());
        }
        return lowObjectDescriptorCollection;
        
	}



	



}
