package middleware;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class LowObject implements ILowObject {
	
	private Map<String,Object> objs;
	
	public LowObject(){
		this.objs = new HashMap<String,Object>();
	}
	

	@Override
	public <T> Object get(T id) {
		
		return this.objs.get(this.lookForAKeyPattern((String) id));
	}
	
	
	public void add(String key, Object val){
		this.objs.put(key, val);
	}
	
	
	
	public int getSize(){
		return this.objs.size();
	}
	
	public Set<String> getKeys(){
		return this.objs.keySet();
	}
	
	private String  lookForAKeyPattern(String pattern){
		 //Pattern di riconoscimento di Regex
		   Pattern p = Pattern.compile(pattern);
		   
		   for(String key : this.objs.keySet()){
			   if(p.matcher(key).find())
				   return key;
		   }
		return "";   
	}
	

}
