package com.geoetsiinf.resources;

import java.util.HashMap;
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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.geoetsiinf.dao.DAOEnums.URIs;
import com.geoetsiinf.dao.DAOException;
import com.geoetsiinf.dao.manager.DAOManager;
import com.geoetsiinf.dao.treasure.TreasureDAO;
import com.geoetsiinf.models.Treasure;
import com.geoetsiinf.models.TreasureModelException;

@Path("/users")
public class UserTreasuresResources {

    static DAOManager daoManager = new DAOManager();

    static TreasureDAO treasureDAO = daoManager.getTreasureDAO();

    
    /** 
     * @param userName
     * @param dateAdded
     * @param start
     * @param amount
     * @param difficulty
     * @return Map<String, Object>
     * @throws DAOException
     */
    private static Map<String, Object> prepareParams(String userName, String dateAdded, Integer start,
            Integer amount, Integer difficulty ) throws DAOException {
        Map<String, Object> preparedParams = new HashMap<>();

        preparedParams.put("author_userName = ", userName);
        if (dateAdded != null) { 
            if (start != null) {
                throw new DAOException("The use of date and start are mutually exclusive");
            }
            preparedParams.put("date_added >", dateAdded);
        }
        else preparedParams.put("user_number >", start); 
        if (amount != null) {
            preparedParams.put("LIMIT = ", amount);
        }
        if (difficulty != null) {
            preparedParams.put("difficulty = ", difficulty);
        }
        return preparedParams;
    }

    @Path("{userName}/treasures")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response get(@PathParam("userName") String userName) throws DAOException {
            List<Treasure> treasures = null;
            try {
                treasures = treasureDAO.getAll(userName);
            } catch (DAOException e) {
                throw new DAOException("Failed to get the added treasure list");
            }
            return Response.status(Response.Status.OK).entity(treasures).build();
    }

    /**
     * @param user
     * @return Response
     */
    @Path("/{userName}/treasures")
    @POST
    @Consumes({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML })
    public static Response createUser(@PathParam("userName") String userName, Treasure treasure) {
        int treasureId = -1; 
        try {
            treasure.setAuthorUserName(userName);
            treasureId = treasureDAO.insert(treasure);
        } catch (DAOException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Treasure could not be created, reason " + e.getMessage())
                    .build();
        }
        return Response.status(Response.Status.CREATED)
                .header("Location", URIs.BASE + "/treasures/" + "/" + treasureId)
                .build();
    }
    

    
    /** 
     * @param @PathParam("userName"
     * @return Response
     */
    @Path("/{userName}/treasures/{treasureId}")
    @DELETE
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public static Response deleteUser(@PathParam("userName") String userID, 
            @PathParam("treasureId") String treasureId) {

        try {

            treasureDAO.delete(userID, treasureId);

        } catch (DAOException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    
    /** 
     * @param @PathParam("userName"
     * @return Response
     */
    @Path("{userName}/treasures/{treasureId}")
    @PUT
    @Consumes ( MediaType.APPLICATION_JSON )
    public static Response updateUser(@PathParam("userName") String userName,
        @PathParam("treasureId") Integer treasureId,  Treasure changes) {

        Treasure modifiedTreasure = null;
        try {
            treasureDAO.getOne(userName, treasureId);
            Map<String, Object> changeMap = changes.toMap();
            treasureDAO.modify(changeMap, treasureId);
            modifiedTreasure = treasureDAO.getOne(userName, treasureId);
        } catch (DAOException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        } catch (TreasureModelException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        return Response.status(Response.Status.OK).entity(modifiedTreasure).build();
    }
}
