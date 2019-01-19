package middleware;

import java.io.File;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class RestClient {

	Client client; 
	WebTarget myResource;
	UriBuilder uBuild;
	
	
	public RestClient(){
		//Il costruttore si comporta come un singleton
		if(this.client == null)
			this.client = ClientBuilder.newClient();
	}
	
	
	
	public File get(){
		
		String res = "devices";
		
		myResource = client.target(uBuild.add(res).getStringUri());
		File fileJson = myResource.request(MediaType.APPLICATION_JSON).get(File.class);
		//client.close();
		return fileJson;
	}

}
