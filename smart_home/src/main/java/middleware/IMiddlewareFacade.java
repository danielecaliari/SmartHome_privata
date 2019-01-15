package middleware;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;

import org.json.simple.parser.ParseException;

import domain.IDescriptor;

public interface IMiddlewareFacade {
	
	Collection<IDescriptor> getDevices() throws FileNotFoundException, IOException, ParseException, Exception;

}
