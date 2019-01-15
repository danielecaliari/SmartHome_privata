package middleware.converters;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public interface IConverter {
	
	//JSONObject parseJSONFile(File f) throws FileNotFoundException, IOException, ParseException;
	
	//<T> Collection<T> convert(File f) throws FileNotFoundException, IOException, ParseException, ParseException;
	
	<T> T convert(File f) throws FileNotFoundException, IOException, ParseException;

}
