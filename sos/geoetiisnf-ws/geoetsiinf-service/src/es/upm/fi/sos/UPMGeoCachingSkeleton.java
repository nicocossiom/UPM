
/**
 * UPMGeoCachingSkeleton.java This file was auto-generated from WSDL by the Apache Axis2 version: 1.6.2 Built on : Apr 17, 2012 (05:33:49
 * IST)
 */
package es.upm.fi.sos;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.apache.axis2.AxisFault;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.context.ServiceContext;
import org.apache.axis2.description.AxisService;
import org.apache.axis2.service.Lifecycle;

import es.upm.fi.sos.model.xsd.*;

import es.upm.fi.sos.UPMAuth.AuthStub;

/**
 * UPMGeoCachingSkeleton java skeleton for the axisService
 */
public class UPMGeoCachingSkeleton implements Lifecycle {
    private static MyUser ADMIN = new MyUser("admin", "admin");

    private int instance;
    private static int instanceCounter = 0;
    AuthStub serviceStub;
    static Map<String, MyUser> clientMap = new HashMap<>();
    // this map has a list of all the instances that attend to a given logged in
    // user
    static Map<String, List<UPMGeoCachingSkeleton>> loggedInstanceMap = new HashMap<>();
    // set of all the treasures in the system
    static Set<MyTreasure> treasures = new HashSet<>();

    java.util.logging.Logger logger = java.util.logging.Logger.getLogger(UPMGeoCachingSkeleton.class.getName());

    public void init(ServiceContext context) {
        context.getConfigurationContext().setProperty("ConfigContextTimeoutInterval", 600000);
        logger.info("Starting up instance " + instance);
        logger.info("The context timeout interval set is "
                + context.getConfigurationContext().getServiceGroupContextTimeoutInterval());
    }

    public void destroy(ServiceContext context) {
        logger.info("Shutting down instance " + instance);
    }

    // implement an equals based on the current instance

    private MyUser sessionUser;

    // create the constructor of this class
    public UPMGeoCachingSkeleton() {
        instance = instanceCounter++;
        sessionUser = null;
        logger.info("\n\n");
        try {
            serviceStub = new AuthStub();
        }
        catch (AxisFault e) {
            logger.info(e.getMessage());
        }
    }

    /**
     * @param addUser
     * @return addUserResponse
     * @throws RemoteException
     */

    public AddUserResponse addUser(AddUser toAdd) throws RemoteException {
        logger.info("the given username is " + toAdd.getArgs0().getUsername());
        AddUserResponse response = new AddUserResponse();
        AddUserResponseParam responseAttr = new AddUserResponseParam();
        responseAttr.setResponse(false);
        // log the current sessionuser username
        logger.info(
                "the current sessionuser username is " + sessionUser.getUsername() + " " + sessionUser.getPassword());
        if (!sessionUser.equals(ADMIN)) {
            logger.info("Current user is not admin.. sending response");
        }
        else {
            try {
                AuthStub.UserBackEnd userBackEnd = new AuthStub.UserBackEnd();
                userBackEnd.setName(toAdd.getArgs0().getUsername());
                AuthStub.AddUser addUser = new AuthStub.AddUser();
                addUser.setUser(userBackEnd);
                logger.info("User is admin, sent request to auth service provider, awaiting response...");
                AuthStub.AddUserResponse serviceResponse = serviceStub.addUser(addUser);
                AuthStub.AddUserResponseBackEnd resVal = serviceResponse.get_return();
                logger.info("auth response: " + resVal.getResult());
                responseAttr.setResponse(resVal.getResult());
                if (resVal.getResult()) {
                    responseAttr.setPwd(resVal.getPassword());
                    // create a myuser using the resVal info and add it to the clientMap
                    MyUser myUser = new MyUser(toAdd.getArgs0().getUsername(), resVal.getPassword());
                    clientMap.put(toAdd.getArgs0().getUsername(), myUser);
                }
            }
            catch (RemoteException e) {
                logger.info(e.getMessage());
            }
        }
        logger.info("done, sending response to client with values: " + responseAttr.getResponse() + " "
                + responseAttr.getPwd());
        response.set_return(responseAttr);
        return response;
    }

    /**
     * @param login
     * @return loginResponse
     */

    public void logout(Logout logout) {
        if (sessionUser != null) {
            logger.info("User " + sessionUser.getUsername() + " logged out");
            if (loggedInstanceMap.containsKey(sessionUser.getUsername())) {
                logger.info("Sesión " + instance + " eliminada de  la lista de sesiones del usuario");
                try {
                    loggedInstanceMap.get(sessionUser.getUsername()).remove(this);
                }
                catch (Exception e) {
                    logger.info(e.getMessage());
                }
            }
            sessionUser = null;
            logger.info("Setteando el userSession a null");
            return;
        }
        else {
            logger.info("No user logged in");
        }
    }

    public LoginResponse login(Login login) {
        String usernameToLogin = login.getArgs0().getName();
        String passwordToLogin = login.getArgs0().getPwd();
        logger.info("the given username is " + usernameToLogin + ", and password is " + passwordToLogin);

        LoginResponse response = new LoginResponse();
        Response responseAttr = new Response();
        responseAttr.setResponse(false);
        // a user is already logged in
        if (sessionUser != null) {
            // the user is trying to login again
            if (usernameToLogin.equals(sessionUser.getUsername())) {
                logger.info("Current user is trying to login again, sending response (true)");
                responseAttr.setResponse(true);
            }
            else {
                // user trying to login is not the same as currently logged user
                logger.info(
                        "A user different from the current logged user is trying to login, sending response (false)");
            }
        }
        // user not logged, might be admin
        else if (usernameToLogin.equals(ADMIN.getUsername()) && passwordToLogin.equals(ADMIN.getPassword())) {
            logger.info("Admin logged in, sending response (true)");
            sessionUser = ADMIN;
            responseAttr.setResponse(true);
        }
        // user is not logged in, might be a client
        else {
            try {
                AuthStub.Login loginService = new AuthStub.Login();
                AuthStub.LoginBackEnd loginAttr = new AuthStub.LoginBackEnd();
                // set the the login to the login service
                loginAttr.setName(usernameToLogin);
                loginAttr.setPassword(passwordToLogin);
                loginService.setLogin(loginAttr);
                logger.info("User is not admin, sending request to auth service provider, awaiting response...");
                // send the login service to the auth service provider
                AuthStub.LoginResponse serviceResponse = serviceStub.login(loginService);
                AuthStub.LoginResponseBackEnd resVal = serviceResponse.get_return();
                logger.info("done, auth response: " + resVal.getResult());
                // check if the login was successful and settin response
                if (resVal.getResult()) {
                    if (!clientMap.containsKey(usernameToLogin)) {
                        // client exists in the auth service provider, but not in the the
                        // clientMap
                        MyUser myUser = new MyUser(usernameToLogin, passwordToLogin);
                        clientMap.put(usernameToLogin, myUser);
                        sessionUser = myUser;
                        logger.info(
                                "User " + usernameToLogin + " is NOT in the clientMap, adding and setting sessionUser");
                    }
                    else {
                        logger.info("User " + usernameToLogin + " is in the clientMap, setting sessionUser");
                        // client exists in the auth service provider, and in clientMap
                        sessionUser = clientMap.get(usernameToLogin);
                    }
                    // check if the current user is in the loggedInstanceMap
                    if (loggedInstanceMap.containsKey(usernameToLogin)) {
                        logger.info("User " + usernameToLogin + " is in the loggedInstanceMap, adding this instance");
                        // add the current user to the loggedInstanceMap
                        loggedInstanceMap.get(usernameToLogin).add(this);
                    }
                    else {
                        logger.info("User " + usernameToLogin
                                + " is not in the loggedInstanceMap, adding an instanceList and this instance");
                        // create a new loggedInstanceMap entry for the current user
                        List<UPMGeoCachingSkeleton> loggedInstances = new ArrayList<>();
                        loggedInstances.add(this);
                        loggedInstanceMap.put(usernameToLogin, loggedInstances);
                    }
                    responseAttr.setResponse(true);
                }
            }
            catch (RemoteException e) {
                logger.info(e.getMessage());
            }
        }
        response.set_return(responseAttr);
        return response;
    }

    /**
     * @param removeUser
     * @return removeUserResponse
     */

    public RemoveUserResponse removeUser(RemoveUser removeUser) {
        String usernameToRemove = removeUser.getArgs0().getUsername();
        logger.info("the given username is " + usernameToRemove);
        RemoveUserResponse response = new RemoveUserResponse();
        Response responseAttr = new Response();
        responseAttr.setResponse(false);
        // check that the given username is not the admin
        if (usernameToRemove.equals(ADMIN.getUsername())) {
            logger.info("Admin is trying to remove himself, sending response (false)");
        }
        else if (sessionUser.equals(ADMIN) || usernameToRemove.equals(sessionUser.getUsername())) {
            try {
                AuthStub.UserBackEnd userBackEnd = new AuthStub.UserBackEnd();
                userBackEnd.setName(usernameToRemove);
                AuthStub.RemoveUser removeUserServiceAttr = new AuthStub.RemoveUser();
                removeUserServiceAttr.setName(removeUser.localArgs0.getUsername());
                removeUserServiceAttr.setPassword(clientMap.get(usernameToRemove).getPassword());
                AuthStub.RemoveUserE removeUserService = new AuthStub.RemoveUserE();
                removeUserService.setRemoveUser(removeUserServiceAttr);
                logger.info(
                        "User is admin or user to be removed, sent request to auth service provider, awaiting response...");
                // send the removeUser service to the auth service provider
                AuthStub.RemoveUserResponseE serviceResponse = serviceStub.removeUser(removeUserService);
                AuthStub.RemoveUserResponse resVal = serviceResponse.get_return();
                logger.info("auth response: " + resVal.getResult());
                responseAttr.setResponse(resVal.getResult());
                // remove the client from the clientMap
                if (resVal.getResult()) {
                    logger.info("User " + usernameToRemove + " removed from clientMap");
                    // remove the client from the map
                    clientMap.remove(usernameToRemove);
                    // logout all the logged instances of the user
                    if (loggedInstanceMap.containsKey(usernameToRemove)) {
                        logger.info(
                                "User " + usernameToRemove + " has " + loggedInstanceMap.get(usernameToRemove).size()
                                        + " instances in the loggedInstanceMap, logging out all instances");

                        int amountInstances = loggedInstanceMap.get(usernameToRemove).size();
                        logger.info("Amount of sessions currently logged in for users" + amountInstances);
                        try {
                            for (int i = amountInstances - 1; i >= 0; i--) {
                                logger.info("Logging out instance " + i);
                                UPMGeoCachingSkeleton instance = loggedInstanceMap.get(usernameToRemove).get(i);
                                instance.logout(new Logout());
                            }
                        }
                        catch (Exception e) {
                            logger.info(e.getClass().getSimpleName() + ": " + e.getMessage());
                        }
                        logger.info("END Amount of sessions currently logged in for users" + amountInstances);
                    }
                    // remove the entry from the map
                    loggedInstanceMap.remove(usernameToRemove);
                }
            }
            catch (RemoteException e) {
                logger.info(e.getMessage());
            }
        }
        else {
            logger.info("Current user is not admin or the user to remove, sending response (false)");
        }
        response.set_return(responseAttr);
        return response;

    }

    /**
     * @param changePassword
     * @return changePasswordResponse
     */

    public ChangePasswordResponse changePassword(ChangePassword changePassword) {
        // extract the new password and old password from the changePassword argument
        String newPassword = changePassword.getArgs0().getNewpwd();
        String oldPassword = changePassword.getArgs0().getOldpwd();
        ChangePasswordResponse response = new ChangePasswordResponse();
        Response responseAttr = new Response();
        responseAttr.setResponse(false);
        if (sessionUser.equals(ADMIN) && oldPassword.equals(ADMIN.getPassword())) {
            logger.info("Admin is changing password, sending response (true)");
            ADMIN.setPassword(newPassword);
            responseAttr.setResponse(true);
        }
        else if (sessionUser.getPassword().equals(oldPassword)) {
            try {
                // create the changePassword service
                AuthStub.ChangePassword changePasswordService = new AuthStub.ChangePassword();
                AuthStub.ChangePasswordBackEnd changePasswordServiceAttr = new AuthStub.ChangePasswordBackEnd();
                // prepare the changePassword service attribute
                changePasswordServiceAttr.setNewpwd(newPassword);
                changePasswordServiceAttr.setOldpwd(oldPassword);
                changePasswordServiceAttr.setName(sessionUser.getUsername());
                logger.info(
                        "User is changing password, sending request to auth service provider, awaiting response...");
                changePasswordService.setChangePassword(changePasswordServiceAttr);
                // call the changePassword service in the auth service provider
                AuthStub.ChangePasswordResponseE serviceResponse = serviceStub.changePassword(changePasswordService);
                AuthStub.ChangePasswordResponse resVal = serviceResponse.get_return();
                logger.info("auth response: " + resVal.getResult());
                responseAttr.setResponse(resVal.getResult());
                // change the password in the localmap
                if (resVal.getResult()) {
                    sessionUser.setPassword(newPassword);
                    logger.info("Password changed successfully");
                }
                else {
                    logger.info("Password change failed");
                }
            }
            catch (RemoteException e) {
                StringWriter sw = new StringWriter();
                e.printStackTrace(new PrintWriter(sw));
                String exceptionAsString = sw.toString();
                logger.info(exceptionAsString);
            }
        }
        else {
            logger.info("Not logged or the old password is wrong, sending response (false)");
        }

        response.set_return(responseAttr);
        return response;
    }

    private boolean isLogged() {
        boolean isLogged = true;
        if (sessionUser == null) {
            isLogged = false;
            logger.info("FAILURE: The user is not logged in");
        }
        return isLogged;
    }

    private boolean isRegistered(String user) {
        boolean isRegistered = true;
        if (!clientMap.containsKey(user)) {
            isRegistered = false;
            logger.info(String.format("FAILURE: The user %s does not exist", user));
        }
        return isRegistered;
    }

    /**
     * @param addFollower
     * @return addFollowerResponse
     */

    public AddFollowerResponse addFollower(AddFollower addFollower) {
        AddFollowerResponse addFollowerResponse = new AddFollowerResponse();
        Response response = new Response();
        response.setResponse(false);
        String toFollow = addFollower.getArgs0().getUsername();
        if (!isLogged() || !isRegistered(toFollow)) {
            addFollowerResponse.set_return(response);
            logger.info("RETURN_VALUE: " + addFollowerResponse.get_return().getResponse());
            return addFollowerResponse;
        }
        boolean added = sessionUser.follow(toFollow);
        if (added) {
            response.setResponse(true);
            logger.info(String.format("SUCCESS: Now following a total of %d users", sessionUser.getFollowed().size()));
        }
        else {
            logger.info("FAILURE: Already following the user " + toFollow);
        }
        addFollowerResponse.set_return(response);
        logger.info("RETURN_VALUE: " + addFollowerResponse.get_return().getResponse());
        return addFollowerResponse;
    }

    /**
     * @param removeFollower
     * @return removeFollowerResponse
     */

    public RemoveFollowerResponse removeFollower(RemoveFollower removeFollower) {
        RemoveFollowerResponse removeFollowerResponse = new RemoveFollowerResponse();
        Response response = new Response();
        response.setResponse(false);
        String toRemove = removeFollower.getArgs0().getUsername();
        if (!isLogged() || !isRegistered(toRemove)) {
            removeFollowerResponse.set_return(response);
            logger.info("RETURN_VALUE: " + removeFollowerResponse.get_return().getResponse());
            return removeFollowerResponse;
        }
        boolean removed = sessionUser.unfollow(toRemove);
        if (removed) {
            response.setResponse(true);
            logger.info(String.format("SUCCESS: Now following a total of %d users", sessionUser.getFollowed().size()));
        }
        else {
            logger.info("FAILURE: Not following the user " + toRemove);
        }
        removeFollowerResponse.set_return(response);
        logger.info("RETURN_VALUE: " + removeFollowerResponse.get_return().getResponse());
        return removeFollowerResponse;
    }

    /**
     * @param getMyFollowers
     * @return getMyFollowersResponse
     */

    public GetMyFollowersResponse getMyFollowers(GetMyFollowers getMyFollowers) {
        GetMyFollowersResponse getMyFollowersResponse = new GetMyFollowersResponse();
        FollowerList followerList = new FollowerList();
        followerList.setResult(false);
        if (!isLogged()) {
            logger.info("RETURN_VALUE: " + getMyFollowersResponse.get_return().getResult());
            return getMyFollowersResponse;
        }
        List<String> resultList = new ArrayList<>();
        for (String following : sessionUser.getFollowed()) {
            resultList.add(following);
        }
        if (!resultList.isEmpty()) {
            followerList.setFollowers(resultList.toArray(new String[0]));
            getMyFollowersResponse.set_return(followerList);
        }
        followerList.setResult(true);
        logger.info("SUCCESS: Following the next users: " + Arrays.toString(followerList.getFollowers()));
        logger.info("RETURN_VALUE: " + getMyFollowersResponse.get_return().getResult());
        return getMyFollowersResponse;
    }

    private boolean isCreated(MyTreasure treasure) {
        boolean isCreated = true;
        if (!treasures.contains(treasure)) {
            logger.info(String.format("FAILURE: The treasure %s does not exist", treasure.getName()));
            isCreated = false;
        }
        return isCreated;
    }

    /**
     * @param createTreasure
     * @return createTreasureResponse
     */

    public CreateTreasureResponse createTreasure(CreateTreasure createTreasure) {
        CreateTreasureResponse createTreasureResponse = new CreateTreasureResponse();
        Response response = new Response();
        response.setResponse(false);
        if (!isLogged()) {
            createTreasureResponse.set_return(response);
            logger.info("RETURN_VALUE: " + createTreasureResponse.get_return().getResponse());
            return createTreasureResponse;
        }
        String name = createTreasure.getArgs0().getName();
        Double latitud = createTreasure.getArgs0().getLatitude();
        Double longitud = createTreasure.getArgs0().getAltitude();
        MyTreasure toCreate = new MyTreasure(name, latitud, longitud);
        if (sessionUser.getTreasuresCreated().contains(toCreate)) {
            int toUpdate = sessionUser.getTreasuresCreated().indexOf(toCreate);
            sessionUser.getTreasuresCreated().get(toUpdate).setLatitude(toCreate.getLatitude());
            sessionUser.getTreasuresCreated().get(toUpdate).setLongitude(toCreate.getLongitude());
            treasures.remove(toCreate);
            treasures.add(toCreate);
            response.setResponse(true);
            logger.info("SUCCESS: Treasure updated");
        }
        else if (!isCreated(toCreate)) {
            sessionUser.addCreatedTreasure(toCreate);
            treasures.add(toCreate);
            response.setResponse(true);
            logger.info("SUCCESS: Treasure created. Total created = " + sessionUser.getTreasuresCreated().size());
        }
        else {
            logger.info("FAILURE: This treasure already exist and it belongs to another user");
        }
        createTreasureResponse.set_return(response);
        logger.info("RETURN_VALUE: " + createTreasureResponse.get_return().getResponse());
        return createTreasureResponse;
    }

    /**
     * @param findTreasure
     * @return findTreasureResponse
     */

    public FindTreasureResponse findTreasure(FindTreasure findTreasure) {
        FindTreasureResponse findTreasureResponse = new FindTreasureResponse();
        Response response = new Response();
        response.setResponse(false);
        String name = findTreasure.getArgs0().getName();
        Double latitud = findTreasure.getArgs0().getLatitude();
        Double longitud = findTreasure.getArgs0().getAltitude();
        MyTreasure foundTreasure = new MyTreasure(name, latitud, longitud);
        if (!isLogged() || !isCreated(foundTreasure)) {
            findTreasureResponse.set_return(response);
            logger.info("RETURN_VALUE: " + findTreasureResponse.get_return().getResponse());
            return findTreasureResponse;
        }
        if (!sessionUser.getTreasuresFound().contains(foundTreasure)) {
            sessionUser.getTreasuresFound().add(foundTreasure);
        }
        response.setResponse(true);
        logger.info("SUCCESS: Found treasure added. Total found = " + sessionUser.getTreasuresFound().size());
        findTreasureResponse.set_return(response);
        logger.info("RETURN_VALUE: " + findTreasureResponse.get_return().getResponse());
        return findTreasureResponse;
    }

    private TreasureList myTreasureListToTreasureList(List<MyTreasure> orderedList) {
        TreasureList treasureList = new TreasureList();
        List<MyTreasure> reverseList = new ArrayList<>(orderedList);
        Collections.reverse(reverseList);
        int size = reverseList.size();
        String[] names = new String[size];
        double[] latitudes = new double[size];
        double[] altitudes = new double[size];
        int i = 0;
        for (MyTreasure t : reverseList) {
            names[i] = t.getName();
            latitudes[i] = t.getLatitude();
            altitudes[i] = t.getLongitude();
            i++;
        }
        treasureList.setNames(names);
        treasureList.setLats(latitudes);
        treasureList.setAlts(altitudes);
        treasureList.setResult(true);
        return treasureList;
    }

    /**
     * @param getMyTreasuresFound
     * @return getMyTreasuresFoundResponse
     */

    public GetMyTreasuresFoundResponse getMyTreasuresFound(GetMyTreasuresFound getMyTreasuresFound) {
        GetMyTreasuresFoundResponse response = new GetMyTreasuresFoundResponse();
        TreasureList responseAttr;
        if (isLogged()) {
            responseAttr = myTreasureListToTreasureList(sessionUser.getTreasuresFound());
            logger.info("SUCCESS: request processed successfully");
        }
        else {
            responseAttr = new TreasureList();
            responseAttr.setResult(false);
        }
        response.set_return(responseAttr);
        logger.info("RETURN_VALUE: " + response.get_return().getResult());
        logger.info("RETURN_LIST: " + Arrays.toString(response.get_return().getNames()));
        return response;
    }

    /**
     * @param getMyTreasuresCreated
     * @return getMyTreasuresCreatedResponse
     */

    public GetMyTreasuresCreatedResponse getMyTreasuresCreated(GetMyTreasuresCreated getMyTreasuresCreated) {
        GetMyTreasuresCreatedResponse response = new GetMyTreasuresCreatedResponse();
        TreasureList responseAttr;
        if (isLogged()) {
            responseAttr = myTreasureListToTreasureList(sessionUser.getTreasuresCreated());
            logger.info("SUCCESS: request processed successfully");
        }
        else {
            responseAttr = new TreasureList();
            responseAttr.setResult(false);
        }
        response.set_return(responseAttr);
        logger.info("RETURN_VALUE: " + response.get_return().getResult());
        logger.info("RETURN_LIST: " + Arrays.toString(response.get_return().getNames()));
        return response;
    }

    private boolean isFollowing(String userName) {
        boolean isFollowing = true;
        if (!sessionUser.getFollowed().contains(userName)) {
            isFollowing = false;
            logger.info("FAILURE: This user is not a follower of " + userName);
        }
        return isFollowing;
    }

    /**
     * @param getMyFollowerTreasuresCreated
     * @return getMyFollowerTreasuresCreatedResponse
     */

    public GetMyFollowerTreasuresCreatedResponse getMyFollowerTreasuresCreated(
            GetMyFollowerTreasuresCreated getMyFollowerTreasuresCreated) {
        String followerName = getMyFollowerTreasuresCreated.getArgs0().getUsername();
        GetMyFollowerTreasuresCreatedResponse response = new GetMyFollowerTreasuresCreatedResponse();
        TreasureList responseAttr;
        if (isLogged() && isFollowing(followerName)) {
            MyUser followedUser = clientMap.get(followerName);
            responseAttr = myTreasureListToTreasureList(followedUser.getTreasuresCreated());
            logger.info("SUCCESS: request processed successfully");
        }
        else {
            responseAttr = new TreasureList();
            responseAttr.setResult(false);
        }
        response.set_return(responseAttr);
        logger.info("RETURN_VALUE: " + response.get_return().getResult());
        logger.info("RETURN_LIST: " + Arrays.toString(response.get_return().getNames()));
        return response;
    }

}
