package middleware;

import java.util.HashMap;
import java.util.Map;

public class LowObject implements ILowObject {
	
	private Map<String,Object> objs;
	
	public LowObject(){
		this.objs = new HashMap<String,Object>();
	}
	

	@Override
	public <T> Object get(T id) {
		
		return this.objs.get(id);
	}
	
	
	public void add(String key, Object val){
		this.objs.put(key, val);
	}
	

}
