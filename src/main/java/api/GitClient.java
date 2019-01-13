package api;

import javax.ws.rs.client.*;
import javax.ws.rs.core.*;

/**This class is responsible for acting as a client when interacting with the GitHub API. This class also as a result contains the methods for interacting with the GitHub API. */
public class GitClient extends Port {
	private static GitClient instance;
	private Client client;
	private WebTarget target;
	
	//on instantiation, set the client and target the github API URI.
	private GitClient() {
		client = ClientBuilder.newClient();
		target = client.target("https://api.github.com");
	}
	
	/**Requests the GitHub API to retrieve the details for a specified username.
	 * @return the JSON object as a String.*/
	public String getUser(String username) {
		Response val = target.path("users").path(username).request().get();
		for(String s: val.getHeaders().keySet()) {
			System.out.println(s + " " + val.getHeaders().get(s)); 
		}
		
		String ent = val.readEntity(String.class);
		
		return ent;
	}
	
	/**Makes a request to the given API GET endpoint to return the JSON object.
	 * @return the JSON object as a String.*/
	public String getURL(String URL) {
		String in = processURL(URL);
		Response val = target.path(in).request().get();
		String ent = val.readEntity(String.class);
		
		return ent;
	}
	
	/**Helper method. Takes a given input URL and removes the target value from the beginning if it's already there.
	 * @return a processed URL String*/
	public String processURL(String URL) {
		String root = target.getUri().toASCIIString();
		
		if(URL.startsWith(root)) {
			return URL.replaceFirst(root, "");
		}
		
		return URL;
	}
	
	@Override
	protected boolean keepAlive() {
		Response val = target.path("zen").request().get();
		return val.hasEntity();
	}
	
	//singleton pattern, there really should only be one of these instantiated at any given point to interact with the github API.
	public static GitClient getClient() {
		if(instance == null) {
			instance = new GitClient();
		}
		return instance;
	}

	@Override
	protected Class<GitClient> getType() {
		return GitClient.class;
	}

	
}
