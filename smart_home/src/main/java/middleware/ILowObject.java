package middleware;

import java.util.Set;

public interface ILowObject {
	
	<T> Object get(T id);
	
	Set<String> getKeys();

}
