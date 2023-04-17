package com.geoetsiinf.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.geoetsiinf.dao.DAOException;
import com.geoetsiinf.dao.friend.FriendDAO;
import com.geoetsiinf.dao.manager.DAOManager;
import com.geoetsiinf.models.User;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FriendResource {

    private DAOManager manager = new DAOManager();
    private FriendDAO friendDAO = manager.getFriendDAO();

    @GET
    public Response getAll(@PathParam("userName") String userName,
            @QueryParam("name") String friendFirstName) throws DAOException {
        List<User> friends = null;
        try {
            friends = friendDAO.getAll(userName, friendFirstName);
        } catch (DAOException e) {
            throw new DAOException("Failed to get the friend list");
        }
        return Response.status(Response.Status.OK).entity(friends).build();
    }

    @PUT
    @Path("{friendUserName}")
    public Response addFriend(@PathParam("userName") String userName,
            @PathParam("friendUserName") String userNameFriend) throws DAOException {
        try {
            friendDAO.insert(userName, userNameFriend);
        } catch (DAOException e) {
            throw new DAOException("Failed to add a friend");
        }
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("{friendUserName}")
    public Response deleteFriend(@PathParam("userName") String userName,
            @PathParam("friendUserName") String friendUserName) throws DAOException {
        try {
            friendDAO.delete(userName, friendUserName);
        } catch (DAOException e) {
            throw new DAOException("Failed to delete a friend");
        }
        return Response.status(Response.Status.NO_CONTENT).build();
    }

}
