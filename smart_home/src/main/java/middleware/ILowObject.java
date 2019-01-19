package middleware;

import java.util.Set;

public interface ILowObject {
	
	<T> Object gett(T id);
	
	Set<String> getKeys();

}
