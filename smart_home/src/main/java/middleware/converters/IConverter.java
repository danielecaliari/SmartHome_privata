package middleware.converters;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import middleware.ILowObject;

public interface IConverter {
	
	Collection<ILowObject> convert(File f, String parameter) throws FileNotFoundException, IOException, ParseException;

}
