package middleware.converters;



import java.util.regex.Pattern;

import org.json.simple.JSONObject;


import middleware.ILowObject;
import middleware.LowObject;

public class LowObjectCreator {
	
	private JSONObject toAdapt;
	
	
	/*public LowDescriptorAdapter(JSONObject obj){
		this.toAdapt = obj;
	}*/
	
	public void setToAdapt(JSONObject toAd){
		this.toAdapt = toAd;
	}
	
	ILowObject convertToLowObject(String parameter){
		
		LowObject res = new LowObject();
		extractAPropertyInto(parameter, res);
		    //System.out.println(res.getSize());
		    System.out.println("//////////////////////");	
	    return res;
	}

	public void extractAPropertyInto(String parameter, LowObject res) {
		//Pattern di riconoscimento di Regex
		   Pattern pattern = Pattern.compile(parameter);
	
		    for(Object key : this.toAdapt.keySet()){
		    	if(pattern.matcher(new String(key.toString())).find()){
		    		System.out.println(key.toString());
		    		System.out.println(this.toAdapt.get(key));
		    		res.add(key.toString(), this.toAdapt.get(key));
		    	}
		    }
	}
	
/*
ILowObject convertToLowObjectFunction(){
		
		LowObject res = new LowObject();
	
		 //Pattern di riconoscimento di Regex
		   Pattern pattern = Pattern.compile("function");
		   System.out.println(pattern.toString());
	    
		    for(Object key : this.toAdapt.keySet()){
		    	if(pattern.matcher(new String(key.toString())).find()){
		    		System.out.println(key.toString());
		    		System.out.println(this.toAdapt.get(key));
		    		res.add(key.toString(), this.toAdapt.get(key));
		    	}
		    	
		    }
		    System.out.println(res.getSize());
		    System.out.println("//////////////////////");	
		    
	    	return res;
	}*/
	

}
