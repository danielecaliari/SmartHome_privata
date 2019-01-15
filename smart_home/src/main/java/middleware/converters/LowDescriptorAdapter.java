package middleware.converters;



import org.json.simple.JSONObject;

import domain.AbstractDescription;
import domain.AbstractId;
import domain.DeviceId;
import middleware.ILowObject;
import middleware.LowObject;

public class LowDescriptorAdapter {
	
	private JSONObject toAdapt;
	
	
	/*public LowDescriptorAdapter(JSONObject obj){
		this.toAdapt = obj;
	}*/
	
	public void setToAdapt(JSONObject toAd){
		this.toAdapt = toAd;
	}
	
	ILowObject convertToLowObject(){
		Object id="";
	    Object description;
	    id = toAdapt.get("dal.device.UID");//.toString();
    	description = this.toAdapt.get("dal.device.name");
    	LowObject res = new LowObject();
    	res.add("dal.device.UID", id);
    	res.add("dal.device.name", description);
    	return res;
	}

}
