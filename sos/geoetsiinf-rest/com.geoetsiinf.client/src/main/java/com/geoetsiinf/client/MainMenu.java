package com.geoetsiinf.client;

import java.util.Scanner;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.Response;


public class MainMenu {
	
	private static final String API_URL = "http://localhost:8080/geoetsiinf/api";
    
	// Initial connection to API
    public static boolean setup(String baseurl) {
        if (!WebClient.connect(baseurl)) {
        	System.out.println("Error connecting to server!");
        	return false;
        } else {
        	System.out.println("Initial setup OK");
        	return true;
        }
    }
    
    // Replaces a blank string with a default value
    private static String filterInput (String defaults, String received) {
    	if (received.equals("") || received == null) {
    		return defaults;
    	} else {
    		return received;
    	}
    }
    
	private static void newUser(Scanner sc) {
		System.out.println("Username:");
		String username = sc.nextLine();
		System.out.println("First name:");
		String firstname = sc.nextLine();
		System.out.println("Last name:");
		String lastname = sc.nextLine();
		System.out.println("E-mail:");
		String email = sc.nextLine();
		System.out.println("Postal code:");
		int postcode = Integer.parseInt(sc.nextLine());
		
		User toBePosted = new User();
		toBePosted.setUserName(username);
		toBePosted.setFirstName(firstname);
		toBePosted.setLastName(lastname);
		toBePosted.setEmail(email);
		toBePosted.setPostalCode(postcode);
		
		Response resp = WebClient.postUser(toBePosted);
		
		System.out.printf("Status code: %d, info: %s\n", resp.getStatus(), resp.getStatusInfo());
	}
	
	private static void newTreasure(Scanner sc) {
		System.out.println("Author:");
		String username = sc.nextLine();
		System.out.println("Treasure name:");
		String treasureName = sc.nextLine();
		System.out.println("X coordinate:");
		float coordinateX = Float.parseFloat(sc.nextLine());
		System.out.println("Y coordinate:");
		float coordinateY = Float.parseFloat(sc.nextLine());
		System.out.println("Terrain type:");
		String terrainType = sc.nextLine();
		System.out.println("Difficulty:");
		int difficulty = Integer.parseInt(sc.nextLine());
		System.out.println("Size:");
		float size = Float.parseFloat(sc.nextLine());
		System.out.println("Hint:");
		String hint = sc.nextLine();

		Treasure newTreas = new Treasure(treasureName, coordinateX, 
				coordinateY, terrainType, 
				difficulty, size, hint, username);
		
		Response resp = WebClient.postTreasure(newTreas, WebClient.getUser(username));
		
		System.out.printf("Status code: %d, info: %s\n", 
				resp.getStatus(), resp.getStatusInfo());
	}
	
	private static void editTreasure(Scanner sc) {
		System.out.println("Login (treasure's owner):");
		String username = sc.nextLine();
		System.out.println("Treasure ID to modify (to delete, type - before it, e.g. -125 instead of 125):");
		String treasureId = sc.nextLine();
		if (Integer.parseInt(treasureId) < 0) {
			System.out.println("Deleting treasure...");
			// find the real id and delete
			int realId = Integer.parseInt(treasureId) * -1;
			Response resp = WebClient.deleteTreasure(Integer.toString(realId), WebClient.getUser(username));
			System.out.printf("Status code: %d, info: %s\n", resp.getStatus(), resp.getStatusInfo());
		} else {
			Treasure toGet = null;
			System.out.println("Editing treasure...");
			try {
				toGet = WebClient.getTreasure(treasureId);
				
				System.out.printf("Treasure name (%s):\n", toGet.getTreasureName());
				String treasureName = sc.nextLine();
				System.out.printf("X coordinate (%s):\n", toGet.getCoordinateX());
				String coordinateX = sc.nextLine();
				System.out.printf("Y coordinate (%s):\n", toGet.getCoordinateY());
				String coordinateY = sc.nextLine();
				System.out.printf("Terrain type (%s):\n", toGet.getTerrainType());
				String terrainType = sc.nextLine();
				System.out.printf("Difficulty out of 10 (%s):\n", toGet.getDifficulty());
				String difficulty = sc.nextLine();
				System.out.printf("Size (%s):\n", toGet.getSize());
				String size = sc.nextLine();
				System.out.printf("Hint (%s):\n", toGet.getHint());
				String hint = sc.nextLine();
				
				toGet.setTreasureName(filterInput(toGet.getTreasureName(), treasureName));
				toGet.setCoordinateX(Float.parseFloat(filterInput(Float.toString(toGet.getCoordinateX()), coordinateX)));
				toGet.setCoordinateY(Float.parseFloat(filterInput(Float.toString(toGet.getCoordinateY()), coordinateY)));
				toGet.setTerrainType(filterInput(toGet.getTerrainType(), terrainType));
				toGet.setDifficulty(Integer.parseInt(filterInput(Integer.toString(toGet.getDifficulty()), difficulty)));
				toGet.setSize(Float.parseFloat(filterInput(Float.toString(toGet.getSize()), size)));
				toGet.setHint(filterInput(toGet.getHint(), hint));
				
				Response resp = WebClient.editTreasure(toGet, treasureId, WebClient.getUser(username));
				
				System.out.printf("Status code: %d, info: %s\n", resp.getStatus(), resp.getStatusInfo());
				
			} catch (Exception e) {
				System.out.println("Cannot get treasure data" + e.getClass().getName());
				e.printStackTrace();
			}
		}
	}
	
	private static void getUser(Scanner sc) {
		System.out.println("Username:");
		String username = sc.nextLine();
		
		try {
			User toGet = WebClient.getUser(username);
			if (toGet == null) {
				System.out.println("Returned user is null!");
			} else {
				System.out.println(toGet);
			}
		} catch (BadRequestException bre) {
			System.out.println("Bad request: user does not exist!");
		} catch (Exception e) {
			System.out.println("Error sending request!");
			e.printStackTrace();
		}
		
	}
	
	private static void editUser(Scanner sc) {
		System.out.println("Username to edit:");
		String username = sc.nextLine();
		boolean founduser = false;
		User toGet = null;
		// get original data by obtaining original user
		try {
			toGet = WebClient.getUser(username);
			if (toGet == null) {
				System.out.println("Returned user is null!");
			} else {
				founduser = true;
			}
		} catch (BadRequestException bre) {
			System.out.println("Bad request: user does not exist!");
		} catch (Exception e) {
			System.out.println("Error sending request!");
			e.printStackTrace();
		}
		if (founduser && toGet != null) {
			System.out.printf("First name (%s):\n", toGet.getFirstName());
			String firstname = sc.nextLine();
			System.out.printf("Last name (%s):\n", toGet.getLastName());
			String lastname = sc.nextLine();
			System.out.printf("E-mail (%s):\n", toGet.getEmail());
			String email = sc.nextLine();
			System.out.printf("Postal code (%s):\n", toGet.getPostalCode());
			int postcode = Integer.parseInt(filterInput(toGet.getPostalCode().toString(), sc.nextLine()));
			
			toGet.setUserName(null);
			toGet.setFirstName(filterInput(toGet.getFirstName(), firstname));
			toGet.setLastName(filterInput(toGet.getLastName(), lastname));
			toGet.setEmail(filterInput(toGet.getEmail(), email));
			toGet.setPostalCode(postcode);
			
			Response resp = WebClient.editUser(toGet);
			
			System.out.printf("Status code: %d, info: %s\n", resp.getStatus(), resp.getStatusInfo());
		}

	}
	
	private static void allUsers(Scanner sc) {
		System.out.println("Listing all users...");
		System.out.println("Name Filter (leave blank if none):");
		String filter = sc.nextLine();
		
		try {
			User[] users = WebClient.getAllUsers(filter);
			for (User myuser : users) {
				System.out.println(myuser);
			}
		} catch (Exception e) {
			System.out.println(e.getClass().getName());
		}
	}
	
	private static void getTreasuresAdded(Scanner sc) {
		System.out.println("Author:");
		String filter = sc.nextLine();
		
		try {
			User user = WebClient.getUser(filter);
			Treasure[] treas = WebClient.getTreasuresAdded(user);
			for (Treasure mytrs : treas) {
				System.out.println(mytrs);
			}
		} catch (Exception e) {
			System.out.println(e.getClass().getName());
		}
	}
	
	private static void findTreasure(Scanner sc) {
		System.out.println("Finder's username:");
		String user = sc.nextLine();
		System.out.println("Treasure ID:");
		String treasureId = sc.nextLine();
		
		Treasure gotten = null;
		User finder = null;
		
		try {
			gotten = WebClient.getTreasure(treasureId);
			finder = WebClient.getUser(user);
		} catch (Exception e) {
			System.out.println("Cannot get treasure data:" 
		+ e.getClass().getName());
		}
		
		System.out.println(gotten.getTreasureId());
		
		if (gotten != null) {
			Response resp = WebClient.findTreasure(gotten, finder);
			
			System.out.printf("Status code: %d, info: %s\n", 
					resp.getStatus(), resp.getStatusInfo());
		}
	}
	
	private static void newFriend(Scanner sc) {
		System.out.println("Login (user to add friend to):");
		String user = sc.nextLine();
		System.out.println("Friend to add:");
		String friend = sc.nextLine();
		
		User friendUsr = null;
		User thisUsr = null;
		
		try {
			friendUsr = WebClient.getUser(friend);
			thisUsr = WebClient.getUser(user);
		} catch (Exception e) {
			System.out.println("Cannot get user data" 
		+ e.getClass().getName());
		}
		
		if (friendUsr != null) {
			Response resp = WebClient.addFriend(thisUsr, friendUsr);
			
			System.out.printf("Status code: %d, info: %s\n", 
					resp.getStatus(), resp.getStatusInfo());
		}
	}
	
	private static void getTreasuresFound(Scanner sc) {
		System.out.println("Author:");
		String filter = sc.nextLine();
		
		try {
			User user = WebClient.getUser(filter);
			Treasure[] treas = WebClient.getTreasuresFound(user);
			for (Treasure mytrs : treas) {
				System.out.println(mytrs);
			}
		} catch (Exception e) {
			System.out.println(e.getClass().getName());
		}
	}
	
	private static void getFriends(Scanner sc) {
		System.out.println("Login (user to get friends of):");
		String user = sc.nextLine();
		
		try {
			User thisUser = WebClient.getUser(user);
			User[] friends = WebClient.getFriends(thisUser);
			for (User friend : friends) {
				System.out.println(friend);
			}
		} catch (Exception e) {
			System.out.println(e.getClass().getName());
		}
	}
	
	private static void deleteUser(Scanner sc) {
		System.out.println("Username to delete:");
		String username = sc.nextLine();
		
		Response resp = WebClient.deleteUser(username);
		System.out.printf("Status code: %d, info: %s\n", resp.getStatus(), resp.getStatusInfo());
	}
	
	private static void deleteFriend(Scanner sc) {
		System.out.println("Login (username to delete friend from):");
		String username = sc.nextLine();
		System.out.println("Friend to delete:");
		String friend = sc.nextLine();
		
		Response resp = WebClient.deleteFriend(WebClient.getUser(username), friend);
		System.out.printf("Status code: %d, info: %s\n", resp.getStatus(), resp.getStatusInfo());
	}
	
	private static void getProfile(Scanner sc) {
		System.out.println("Username to obtain profile from:");
		String username = sc.nextLine();
		
		try {
			User user = WebClient.getUser(username);
			Profile toGet = WebClient.getProfile(user);
			if (toGet == null) {
				System.out.println("Returned user is null!");
			} else {
				// Basic information
				System.out.println(WebClient.getUser(username));
				
				// Numerical data
				System.out.println("Total found treasures: " + toGet.getNumFoundTreasures());
				System.out.println("Number of friends: " + toGet.getNumFriends());
				System.out.println("Number of added treasures: " + toGet.getNumAddedTreasures());
				
				// last found treasures
				System.out.println("Last found treasures:");
				Treasure[] treas = toGet.getLastFoundTreasures();
				for (Treasure mytrs : treas) {
					System.out.println(mytrs);
				}
			}
		} catch (BadRequestException bre) {
			System.out.println("Bad request: user data cannot be retrieved");
		} catch (Exception e) {
			System.out.println("Error sending request!");
			e.printStackTrace();
		}
	}

	private static void getTreasuresPos(Scanner sc) {
		System.out.println("X coordinate:");
		float coordinateX = Float.parseFloat(sc.nextLine());
		System.out.println("Y coordinate:");
		float coordinateY = Float.parseFloat(sc.nextLine());
		
		try {
			Treasure[] treas = WebClient.getTreasures(coordinateX, coordinateY);
			for (Treasure mytrs : treas) {
				System.out.println(mytrs);
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getClass().getName());
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// initialize the web client
		System.out.println("Set API entry point (or leave blank for http://localhost:8080/geoetsiinf/api)");
		String url = filterInput(API_URL, sc.nextLine());
		boolean exit = !setup(url);
		
		// main menu loop
		while (!exit) {
			System.out.println("--- GeoETSIINF REST Client ---"); 
			System.out.println("Please select an option..."); 
			System.out.println("0. Exit the program");
			System.out.println("1. Add new user");
			System.out.println("2. Get a user");
			System.out.println("3. Edit a user");
			System.out.println("4. Delete a user");
			System.out.println("5. Get all users");
			System.out.println("6. Add a treasure");
			System.out.println("7. Edit or delete a treasure");
			System.out.println("8. Get treasures added by user");
			System.out.println("9. Register treasure as found");
			System.out.println("A. Get treasures found by user");
			System.out.println("B. Add a friend");
			System.out.println("C. List a user's friends");
			System.out.println("D. Delete a friend");
			System.out.println("E. Get treasures closest to a spot");
			System.out.println("F. Get user's profile");
			
			
			char chRead = sc.next().charAt(0);
			sc.nextLine();
			switch (chRead) {
				case '0':
					System.out.println("Exiting...");
					exit = true;
					break;
				case '1':
					newUser(sc);
					break;
				case '2':
					getUser(sc);
					break;
				case '3':
					editUser(sc);
					break;
				case '4':
					deleteUser(sc);
					break;
				case '5':
					allUsers(sc);
					break;
				case '6':
					newTreasure(sc);
					break;
				case '7':
					editTreasure(sc);
					break;
				case '8':
					getTreasuresAdded(sc);
					break;
				case '9':
					findTreasure(sc);
					break;
				case 'A':
					getTreasuresFound(sc);
					break;
				case 'B':
					newFriend(sc);
					break;
				case 'C':
					getFriends(sc);
					break;
				case 'D':
					deleteFriend(sc);
					break;
				case 'E':
					getTreasuresPos(sc);
					break;
				case 'F':
					getProfile(sc);
					break;
				default:
					System.out.println("Invalid option chosen");
					break;
			}
		}
	}

}
