package dtos;

import java.util.HashMap;

public class GitUserDTO {
	private String login;
	private long id;
	private String nodeId;
	private String avatarURL;
	private long gravatarId;
	private String userURL;
	private String followersURL;
	private String followingURL;
	private String gistsURL;
	private String starredURL;
	private String subscriptionsURL;
	private String organisationsURL;
	private String reposURL;
	private String eventsURL;
	private String receivedEventsURL;
	private String type;
	private String name;
	private String company;
	private String blog;
	private String location;
	private String email;
	
	public GitUserDTO(String login, long id, String nodeId, String avatarURL, long gravatarId, String userURL, String followersURL, String followingURL, 
			String gistsURL, String starredURL, String subscriptionsURL, String organisationsURL, String reposURL, String eventsURL, String receivedEventsURL, 
			String type, String name, String company, String blog, String location, String email) {
		this.login = login;
		this.id = id;
		this.nodeId = nodeId;
		this.avatarURL = avatarURL;
		this.gravatarId = gravatarId;
		this.userURL = userURL;
		this.followersURL = followersURL;
		this.followingURL = followingURL;
		this.gistsURL = gistsURL;
		this.starredURL = starredURL;
		this.subscriptionsURL = subscriptionsURL;
		this.organisationsURL = organisationsURL;
		this.reposURL = reposURL;
		this.eventsURL = eventsURL;
		this.receivedEventsURL = receivedEventsURL;
		this.type = type;
		this.name = name;
		this.company = company;
		this.blog = blog;
		this.location = location;
		this.email = email;
	}
	
	public static GitUserDTO build(HashMap<String, String> vals) {
		String login = vals.get("login");
		long id = Long.parseLong(vals.get("id"));
		String nodeId = vals.get("nodeId");
		String avatarURL = vals.get("avatar_url");
		long gravatarId = Long.parseLong(vals.get("gravatar_id"));
		String userURL = vals.get("html_url");
		String followersURL = vals.get("followers_url");
		String followingURL = vals.get("following_url");
		String gistsURL = vals.get("gists_url");
		String starredURL = vals.get("starred_url");
		String subscriptionsURL = vals.get("subscriptions_url");
		String organisationsURL = vals.get("organizations_url");
		String reposURL = vals.get("repos_url");
		String eventsURL = vals.get("events_url");
		String receivedEventsURL = vals.get("received_events_url");
		String type = vals.get("type");
		String name = vals.get("name");
		String company = vals.get("company");
		String blog = vals.get("blog");
		String location = vals.get("location");
		String email = vals.get("email");
		
		return new GitUserDTO(login, id, nodeId, avatarURL, gravatarId, userURL, followersURL, followingURL, gistsURL, starredURL, subscriptionsURL, organisationsURL, reposURL, eventsURL, receivedEventsURL, type, name, company, blog, location, email);
	}
}
