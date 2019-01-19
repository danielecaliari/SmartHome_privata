package middleware;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.json.simple.JSONObject;

public class LowObject extends JSONObject implements ILowObject {
	
	private Map<String,Object> objs;
	
	public LowObject(){
		this.objs = new HashMap<String,Object>();
	}
	

	@Override
	public <T> Object gett(T id) {
		//System.out.println(this.objs.get(this.lookForAKeyPattern((String) id)));
		
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
		  // System.out.println(pattern);
		   
		   for(String key : this.objs.keySet()){
			   //System.out.println(key);
			   if(p.matcher(key).find())
				   return key;
		   }
		return "";   
	}
	

}
