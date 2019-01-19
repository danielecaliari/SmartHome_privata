package middleware;

public class UriBuilder {
	
	private final static String baseUri = "http://localhost:8080/api/";
	
	private String uri;
	
	public UriBuilder add(Object resource){
		this.uri.concat(resource.toString());
		return this;
	}
	
	public String getStringUri(){
		return this.baseUri + uri;
	}

}
