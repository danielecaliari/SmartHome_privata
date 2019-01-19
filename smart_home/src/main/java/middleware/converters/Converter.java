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
	public Collection<ILowObject> convert(File f,String p) throws FileNotFoundException, IOException, ParseException{
		return this.convertToLowObjectCollectionF(new Parser().parseJSONFile(f), p);
	 }
	
	

public Collection<ILowObject> convertToLowObjectCollectionF(JSONObject jo,String parameter) throws FileNotFoundException, IOException, ParseException, org.json.simple.parser.ParseException {
		
	List<ILowObject> lowObjectCollection = new ArrayList<ILowObject>();  
    JSONArray ja = (JSONArray) jo.get("result");
    
    LowObjectCreator creator = new LowObjectCreator();
    
    for (Object element : ja) {
    	creator.setToAdapt((JSONObject) element); 	
        lowObjectCollection.add(creator.convertToLowObject(parameter));
    }
    return lowObjectCollection;
    
}


	



}
