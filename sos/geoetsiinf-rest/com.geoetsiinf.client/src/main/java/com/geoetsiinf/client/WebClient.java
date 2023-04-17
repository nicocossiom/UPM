package com.geoetsiinf.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/*
 * WebClient class. Handles communication with the API
 */

public class WebClient {
	
	private static String base;
	private static String users;
	private static String treasures;
	private static Client client;
	private static API api;
	
	
	public static boolean connect(String baseurl) {
		// initialize the client
		try {
			base = baseurl;
			client = ClientBuilder.newClient();
			api = client.target(base)
					.request(MediaType.APPLICATION_JSON)
					.get(API.class);
			users = api.getUsers();
			treasures = api.getTreasures();
			return true;
		} catch (Exception e) {
			System.err.println(e.getClass());
			return false;
		}
	}
	
	public static Response postUser(User toBePosted) {
		return client.target(users)
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(toBePosted, MediaType.APPLICATION_JSON));
	}
	
	public static Response postTreasure(Treasure toBePosted, User author) {
		String target = author.getTreasures();
		return client.target(target)
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(toBePosted, MediaType.APPLICATION_JSON));
	}
	
	public static Response editUser(User toBePosted) {
		return client.target(toBePosted.getHref())
				.request(MediaType.APPLICATION_JSON)
				.put(Entity.entity(toBePosted, MediaType.APPLICATION_JSON));
	}
	
	public static User getUser(String usrname) {
		return client.target(users)
				.path(usrname)
				.request(MediaType.APPLICATION_JSON)
				.get(User.class);
	}
	
	public static Treasure getTreasure(String id) {
		return client.target(treasures)
				.path(id)
				.request(MediaType.APPLICATION_JSON)
				.get(Treasure.class);
	}
	
	public static Response findTreasure(Treasure tr, User user) {
		String target = user.getFoundTreasures();
		Integer id = tr.getTreasureId();
		return client.target(target)
				.path(id.toString())
				.request(MediaType.APPLICATION_JSON)
				.put(Entity.entity(tr, MediaType.APPLICATION_JSON));
	}
	
	public static Response addFriend(User user, User friend) {
		String target = user.getFriends();
		return client.target(target)
				.path(friend.getUserName())
				.request(MediaType.APPLICATION_JSON)
				.put(Entity.entity(friend, MediaType.APPLICATION_JSON));
	}
	
	public static User[] getAllUsers(String filter) {
		if (filter.equals("") || filter == null) {
			// no filter
			return client.target(users)
					.request(MediaType.APPLICATION_JSON)
					.get(User[].class);
		} else {
			return client.target(users)
					.queryParam("name", filter)
					.request(MediaType.APPLICATION_JSON)
					.get(User[].class);
		}
	}
	
	public static Treasure[] getTreasuresAdded(User author) {
		String target = author.getTreasures();
			return client.target(target)
					.request(MediaType.APPLICATION_JSON)
					.get(Treasure[].class);
	}
	
	public static Treasure[] getTreasuresFound(User user) {
		String target = user.getFoundTreasures();
			return client.target(target)
					.request(MediaType.APPLICATION_JSON)
					.get(Treasure[].class);
	}
	
	public static Treasure[] getTreasures(float coordX, float coordY) {
			return client.target(treasures)
					.queryParam("coordinateX", coordX)
					.queryParam("coordinateY", coordY)
					.request(MediaType.APPLICATION_JSON)
					.get(Treasure[].class);
	}
	
	public static Response deleteUser(String usrname) {
		return client.target(users)
				.path(usrname)
				.request(MediaType.APPLICATION_JSON)
				.delete(Response.class);
	}
	
	public static Response deleteFriend(User user, String friend) {
		String target = user.getFriends();
		return client.target(target)
				.path(friend)
				.request(MediaType.APPLICATION_JSON)
				.delete(Response.class);
	}
	
	public static Response deleteTreasure(String id,  User user) {
		String target = user.getTreasures();
		return client.target(target)
				.path(id)
				.request(MediaType.APPLICATION_JSON)
				.delete(Response.class);
	}

	public static User[] getFriends(User user) {
		String target = user.getFriends();
		return client.target(target)
				.request(MediaType.APPLICATION_JSON)
				.get(User[].class);
	}
	
	public static Profile getProfile(User user) {
		String target = user.getProfile();
		return client.target(target)
				.request(MediaType.APPLICATION_JSON)
				.get(Profile.class);
	}

	public static Response editTreasure(Treasure toBePosted, String treasureId, User user) {
		String target = user.getTreasures();
		return client.target(target)
				.path(treasureId)
				.request(MediaType.APPLICATION_JSON)
				.put(Entity.entity(toBePosted, MediaType.APPLICATION_JSON));
	}
}
