package com.geoetsiinf.resources;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.geoetsiinf.dao.DAOException;
import com.geoetsiinf.dao.user.UserDAO;
import com.geoetsiinf.models.User;
import com.geoetsiinf.models.UserModelException;
import com.geoetsiinf.dao.DAOEnums.URIs;
import com.geoetsiinf.dao.manager.DAOManager;

@Path("/users")
public class UsersResources {

    static DAOManager daoManager = new DAOManager();

    static UserDAO userDAO = daoManager.getUserDAO(); 
    
    /**
     * @param user
     * @return Response
     */
    @POST
    @Consumes({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML })
    public static Response createUser(User user) {
        try {
            userDAO.insert(user);
        } catch (DAOException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("User could not be created, reason: " + e.getMessage())
                    .build();
        }
        return Response.status(Response.Status.CREATED)
                .header("Location", URIs.BASE + "/users/" + user.getUserName())
                .build();
    }
    

    /**
     * @param nameFilter
     * @return Response
     */
    @GET
    @Produces( MediaType.APPLICATION_JSON )
    public static Response get(@QueryParam("name") String nameFilter) {
        
        List<User> resultList = null;
        try {
            // no filters, we return all users in the system
            if (nameFilter == null) {
                resultList = userDAO.getAll();
            } else {
                resultList = userDAO.getWithFilter(nameFilter);
            }
        } catch (DAOException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        if (resultList == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.status(Response.Status.OK)
                .entity(resultList)
                .build();
    }

    
    /** 
     * @param userID
     * @return Response
     * @throws DAOException
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{userName}")
    public Response getUser(@PathParam("userName") String userName) throws DAOException {
        User user = null;
        try {            
            user = userDAO.getOne(userName);
        } catch (DAOException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        
        return Response.status(Response.Status.OK).entity(user).build();
    }
    
    /** 
     * @param userID
     * @return Response
     */
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{userName}")
    public static Response deleteUser(@PathParam("userName") String userID) {
        
        try {
            
            userDAO.delete(userID);

        } catch (DAOException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    
    /** 
     * @param userName
     * @param changes
     * @return Response
     */
    @PUT
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("{userName}")
    public static Response updateUser(@PathParam("userName") String userName, User changes) {
        User modifiedUser = null;
        try {    
            userDAO.doesUserExist(userName);
            Map<String, Object> changeMap = changes.toMap();
            changeMap.put("user_name", userName); 
            userDAO.modify(changeMap);
            modifiedUser = userDAO.getOne(userName);
        } catch (DAOException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        } catch (UserModelException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        return Response.status(Response.Status.OK).entity(modifiedUser).build();
    }

    @Path("/{userName}/friends")
    public FriendResource getFriendResource() {
        return new FriendResource();
    }

    @Path("/{userName}/foundTreasures")
    public FoundTreasureResource getFoundTreasureResource() {
        return new FoundTreasureResource();
    }

    @Path("/{userName}/profile")
    public ProfileResource getProfileResource() {
        return new ProfileResource();
    }
    
}
