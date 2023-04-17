package com.geoetsiinf.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.geoetsiinf.dao.DAOException;
import com.geoetsiinf.dao.foundTreasure.FoundTreasureDAO;
import com.geoetsiinf.dao.manager.DAOManager;
import com.geoetsiinf.models.Treasure;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class FoundTreasureResource {

    private DAOManager manager = new DAOManager();
    private FoundTreasureDAO foundTreasureDAO = manager.getFoundTreasureDAO();

    @GET
    public Response getAll(@PathParam("userName") String userName,
            @QueryParam("before") String dateAdded) throws DAOException {
        List<Treasure> treasures = null;
        try {
            treasures = foundTreasureDAO.getAll(userName, dateAdded);
        } catch (DAOException e) {
            throw new DAOException("Failed to get the found treasures list");
        }
        return Response.status(Response.Status.OK).entity(treasures).build();
    }

    @PUT
    @Path("{treasureId}")
    public Response addFriend(@PathParam("userName") String userName,
            @PathParam("treasureId") String treasureID) throws DAOException {
        try {
            foundTreasureDAO.insert(userName, treasureID);
        } catch (DAOException e) {
            throw new DAOException("Failed to add a found treasure");
        }
        return Response.status(Response.Status.CREATED).build();
    }
    
}
