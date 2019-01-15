package middleware;

import java.io.File;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class RestClient {
	
	private final static String baseUri = "http://localhost:8080/api/";
	Client client; //= ClientBuilder.newClient();
	WebTarget myResource; //= client.target("http://localhost:8080/api/devices");
	
	
	public RestClient(){
		//Il costruttore si comporta come un singleton
		if(this.client == null)
			this.client = ClientBuilder.newClient();
	}
	
	
	
	public File get(){
		//Client client = ClientBuilder.newClient();
		String res = "devices";
		myResource = client.target(this.baseUri + res);
		File fileJson = myResource.request(MediaType.APPLICATION_JSON).get(File.class);
		//client.close();
		return fileJson;
	}

}
