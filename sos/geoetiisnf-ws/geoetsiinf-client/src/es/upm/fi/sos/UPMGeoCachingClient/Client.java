package es.upm.fi.sos.UPMGeoCachingClient;

import java.rmi.RemoteException;
import java.util.Scanner;

import javax.swing.text.PasswordView;

import org.apache.axiom.om.util.LogOutputStream;
import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.context.ConfigurationContext;

import es.upm.fi.sos.UPMGeoCachingClient.ServiceStub;
import es.upm.fi.sos.UPMGeoCachingClient.ServiceStub.*;

public class Client {
    public static ServiceStub stub;
    private static boolean logged = false;

    public static void main(String[] args) throws Exception {
        stub = new ServiceStub();
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        
        stub._getServiceClient().getOptions().setManageSession(true);
        stub._getServiceClient().engageModule("addressing");

        // main menu loop
        while (!exit) {
            System.out.println("--- GeoETSIINF SOAP Client ---");
            System.out.println("Please select an option...");
            System.out.println("\t0. Exit the program");
            System.out.println("\t1. Login as admin");
            System.out.println("\t2. Login giving a username and password");
            System.out.println("\t3. Logout of the current session");
            System.out.println("\t4. Add a user (must be logged as admin)");
            System.out.println("\t5. Remove a user (must be logged as admin or the user to be removed)");
            System.out.println("\t6. Change a non admin user's password (must be logged as the user to be changed)");
            System.out.println("\t7. Add a follower (to the current logged user)");
            System.out.println("\t8. Get the logged user's followers");
            System.out.println("\t9. Create a new treasure (as the current logged user)");
            System.out.println("\tA. Mark a treasure as found (as the current logged user)");
            System.out.println("\tB. Get the treasures found by the logged user");
            System.out.println("\tC. Get the treasures created by the logged user");
            System.out.println("\tD. Get the treasures created by a follower of the logged user");
            System.out.println("\tE. Remove a follower");

            char chRead = sc.next().charAt(0);
            sc.nextLine();
            switch (chRead) {
            // la idea de este switch es nada más que llamar a la funcion pasando el scannerpara que lea los inputs
            // correspondientes y haga con ellos lo que sea necesario
            case '0':
                System.out.println("Exiting...");
                logout();
                exit = true;
                break;
            case '1':
                loginAsAdmin();
                break;
            case '2':
                login(sc);
                break;
            case '3':
                logout();
                break;
            case '4':
                addUser(sc);
                break;
            case '5':
                removeUser(sc);
                break;
            case '6':
                changeUserPassword(sc);
                break;
            case '7':
                addFollower(sc);
                break;
            case '8':
                getFollowers(sc);
                break;
            case '9':
                createTreasure(sc);
                break;
            case 'A':
                findTreasure(sc);
                break;
            case 'B':
                getMyTreasuresFound();
                break;
            case 'C':
                getMyTreasuresCreated();
                break;
            case 'D':
                getMyTreasuresCreatedByFollower(sc);
                break;
            case 'E':
            	removeFollower(sc);
            	break;
            default:
                System.out.println("Invalid option chosen");
                break;
            }
        }
    }

    private static void getMyTreasuresCreatedByFollower(Scanner sc) {
        // get the follower name
        System.out.println("Please enter the follower's username");
        String followerName = sc.nextLine();
        GetMyFollowerTreasuresCreated getMyFollowerTreasuresCreated = new GetMyFollowerTreasuresCreated();
        Username username = new Username();
        username.setUsername(followerName);
        getMyFollowerTreasuresCreated.setArgs0(username);
        try {
            GetMyFollowerTreasuresCreatedResponse response = stub
                    .getMyFollowerTreasuresCreated(getMyFollowerTreasuresCreated);
            if (response.get_return().getResult()) {
                System.out.println("Treasures created by " + followerName + " :");
                // extract each of the arrays: names, latitude, altitude in the return to variables
                String[] names = response.get_return().getNames();
                double[] latitudes = response.get_return().getLats();
                double[] altitudes = response.get_return().getAlts();
                for (int i = 0; i < names.length; i++) {
                    System.out
                            .println("\tTreasure " + i + ": " + names[i] + " at " + latitudes[i] + "," + altitudes[i]);
                }
            } else {
                System.out.println("No treasures found");
            }
        } catch (RemoteException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    private static void getMyTreasuresCreated() {
        GetMyTreasuresCreated getMyTreasuresCreated = new GetMyTreasuresCreated();
        // do the request, check the result, if correct print each of the treausres values
        try {
            GetMyTreasuresCreatedResponse response = stub.getMyTreasuresCreated(getMyTreasuresCreated);
            if (response.get_return().getResult()) {
                System.out.println("Treasures created:");
                // extract each of the arrays: names, latitude, altitude in the return to variables
                String[] names = response.get_return().getNames();
                double[] latitudes = response.get_return().getLats();
                double[] altitudes = response.get_return().getAlts();
                for (int i = 0; i < names.length; i++) {
                    System.out
                            .println("\tTreasure " + i + ": " + names[i] + " at " + latitudes[i] + "," + altitudes[i]);
                }
            } else {
                System.out.println("No treasures found");
            }
        } catch (RemoteException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
    
    private static void removeFollower(Scanner sc) {
        System.out.println("Enter the username of the follower to remove");
        String username = sc.nextLine();
        RemoveFollower remFollower = new RemoveFollower();
        Username user = new Username();
        user.setUsername(username);
        remFollower.setArgs0(user);
        try {
            RemoveFollowerResponse response = stub.removeFollower(remFollower);
            // check if the response is correct
            if (response.get_return().getResponse()) {
                System.out.println("Follower removed");
            } else {
                System.out.println("Operation failed");
            }
        } catch (RemoteException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    private static void getMyTreasuresFound() {
        GetMyTreasuresFound getMyTreasuresFound = new GetMyTreasuresFound();
        // do the request, check the result, if correct print each of the treausres values
        try {
            GetMyTreasuresFoundResponse response = stub.getMyTreasuresFound(getMyTreasuresFound);
            if (response.get_return().getResult()) {
                System.out.println("Treasures found:");
                // extract each of the arrays: names, latitude, altitude in the return to variables
                String[] names = response.get_return().getNames();
                double[] latitudes = response.get_return().getLats();
                double[] altitudes = response.get_return().getAlts();
                for (int i = 0; i < names.length; i++) {
                    System.out
                            .println("\tTreasure " + i + ": " + names[i] + " at " + latitudes[i] + "," + altitudes[i]);
                }
            } else {
                System.out.println("No treasures found");
            }
        } catch (RemoteException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    private static void findTreasure(Scanner sc) {
        System.out.println("Please enter the treasure's name");
        String treasureName = sc.nextLine();
        System.out.println("Please enter the treasure's latitude");
        double treasureLatitude = sc.nextDouble();
        System.out.println("Please enter the treasure's longitude");
        double treasureLongitude = sc.nextDouble();
        FindTreasure findTreasure = new FindTreasure();
        Treasure treasure = new Treasure();
        treasure.setName(treasureName);
        treasure.setLatitude(treasureLatitude);
        treasure.setAltitude(treasureLongitude);
        findTreasure.setArgs0(treasure);
        try {
            FindTreasureResponse response = stub.findTreasure(findTreasure);
            if (response.get_return().getResponse()) {
                System.out.println("Treasure found added");
            } else {
                System.out.println("Treasure not found");
            }
        } catch (RemoteException e) {
            System.out.println("RemoteException: " + e.getMessage());
        }
    }

    private static void createTreasure(Scanner sc) {
        System.out.println("Please enter the treasure's name");
        String treasureName = sc.nextLine();
        System.out.println("Please enter the treasure's latitude");
        double treasureLatitude = sc.nextDouble();
        System.out.println("Please enter the treasure's longitude");
        double treasureLongitude = sc.nextDouble();
        CreateTreasure createTreasure = new CreateTreasure();
        Treasure treasure = new Treasure();
        treasure.setName(treasureName);
        treasure.setLatitude(treasureLatitude);
        treasure.setAltitude(treasureLongitude);
        createTreasure.setArgs0(treasure);
        try {
            CreateTreasureResponse response = stub.createTreasure(createTreasure);
            // check if the treasure was created
            if (response.get_return().getResponse()) {
                System.out.println("Treasure created successfully");
            } else {
                System.out.println("Treasure creation failed");
            }
        } catch (RemoteException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void getFollowers(Scanner sc) {
        GetMyFollowers getMyFollowers = new GetMyFollowers();
        try {
            GetMyFollowersResponse response = stub.getMyFollowers(getMyFollowers);
            if (response.get_return().getResult()) {
                System.out.println("Followers:");
                for (String follower : response.get_return().getFollowers()) {
                    System.out.println("\t" + follower);
                }
            } else {
                System.out.println("Operation failed");
            }

        } catch (RemoteException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void addFollower(Scanner sc) {
        System.out.println("Enter the username of the user to add as follower");
        String username = sc.nextLine();
        AddFollower addFollower = new AddFollower();
        Username user = new Username();
        user.setUsername(username);
        addFollower.setArgs0(user);
        try {
            AddFollowerResponse response = stub.addFollower(addFollower);
            // check if the response is correct
            if (response.get_return().getResponse()) {
                System.out.println("User added as follower");
            } else {
                System.out.println("Operation failed");
            }
        } catch (RemoteException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void changeUserPassword(Scanner sc) {
        System.out.println("Please enter the old password");
        String oldPassword = sc.nextLine();
        System.out.println("Please enter the new password");
        String newPassword = sc.nextLine();
        ChangePassword changePassword = new ChangePassword();
        PasswordPair passwordPair = new PasswordPair();
        passwordPair.setOldpwd(oldPassword);
        passwordPair.setNewpwd(newPassword);
        changePassword.setArgs0(passwordPair);
        try {
            ChangePasswordResponse response = stub.changePassword(changePassword);
            if (response.get_return().getResponse()) {
                
                System.out.println("Password changed successfully");
            } else {
                System.out.println("Password change failed");
            }
        } catch (RemoteException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void removeUser(Scanner sc) {
        System.out.println("Input username:");
        String username = sc.nextLine();
        RemoveUser rm = new RemoveUser();
        Username user = new Username();
        user.setUsername(username);
        rm.setArgs0(user);
        try {
            RemoveUserResponse rmResponse = stub.removeUser(rm);
            if (rmResponse.get_return().getResponse()) {
                System.out.println("User removed");
            } else {
                System.out.println("Operation failed, user was not removed");
            }
        } catch (RemoteException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    private static void addUser(Scanner sc) {
        System.out.println("Input username:");
        String username = sc.nextLine();
        AddUser addUser = new AddUser();
        Username user = new Username();
        user.setUsername(username);
        addUser.setArgs0(user);
        try {
            AddUserResponseE res = stub.addUser(addUser);
            if (res.get_return().getResponse()) {
                System.out.println("User added successfully");
                System.out.println("Password: " + res.get_return().getPwd());

            } else {
                System.out.println("Error adding user");
            }
        } catch (RemoteException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void logout() {
        Logout logout = new Logout();
        // create the request check the result and print the response
        try {
            stub.logout(logout);
            logged = false;
            System.out.println("Logged out.");
        } catch (RemoteException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void login(Scanner sc) {
    	if (logged) {
    		System.out.println("Warning: Already logged in in this session");
    	}
        System.out.println("Input username:");
        String username = sc.nextLine();
        System.out.println("Input password:");
        String password = sc.nextLine();
        Login login = new Login();
        User user = new User();
        user.setName(username);
        user.setPwd(password);
        login.setArgs0(user);
        try {
            LoginResponse loginResponse = stub.login(login);
            if (loginResponse.get_return().getResponse()) {
                System.out.println("Login successful");
                logged = true;

            } else {
                System.out.println("Login failed");
            }
        } catch (RemoteException e) {
            System.out.println("Error: " + e.getMessage());

        }

    }

    private static void loginAsAdmin() {
    	if (logged) {
    		System.out.println("Warning: Already logged in in this session");
    		return;
    	}
        Login login = new Login();
        User user = new User();
        user.setName("admin");
        user.setPwd("admin");
        login.setArgs0(user);
        try {
            LoginResponse loginResponse = stub.login(login);
            if (loginResponse.get_return().getResponse()) {
                System.out.println("Login successful");
                logged = true;

            } else {
                System.out.println("Login failed");
            }
        } catch (RemoteException e) {
            System.out.println("Error: " + e.getMessage());

        }
    }
}
