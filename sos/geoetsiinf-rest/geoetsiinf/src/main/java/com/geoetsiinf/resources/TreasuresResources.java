package com.geoetsiinf.resources;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.geoetsiinf.dao.DAOException;
import com.geoetsiinf.dao.manager.DAOManager;
import com.geoetsiinf.dao.treasure.TreasureDAO;
import com.geoetsiinf.models.Treasure;

@Path("treasures")
public class TreasuresResources {
    static DAOManager daoManager = new DAOManager();

    static TreasureDAO treasureDAO = daoManager.getTreasureDAO();

    /**
     * @param userName
     * @param coordinateX
     * @param coordinateY
     * @param dateAdded
     * @param start
     * @param amount
     * @param difficulty
     * @return Map<String, Object>
     * @throws DAOException
     */
    private static Map<String, Object> prepareParams(String dateAdded, Integer start, Integer amount,
            Integer difficulty) throws DAOException {

        Map<String, Object> preparedParams = new HashMap<>();
        if (start != null) {
            if (amount != null) {
                preparedParams.put("treasure_id <", start + amount);
            } 
            preparedParams.put("treasure_id > ", start);
        }
        if (dateAdded != null) {
            preparedParams.put("date_added < ", "'" + dateAdded + "'");
        }
        if (difficulty != null) {
            preparedParams.put("difficulty = ", difficulty);
        }
        return preparedParams;
    }

    /**
     * @param @PathParam("userName"
     * @return Response
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public static Response get(
            @QueryParam("coordinateX") Double coordinateX, @QueryParam("coordinateY") Double coordinateY,
            @QueryParam("before") String dateAdded, @QueryParam("start") Integer start,
            @QueryParam("amount") Integer amount, @QueryParam("difficulty") Integer difficulty) {
        List<Treasure> treasures = null;
        if (coordinateX == null || coordinateY == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Coordinates are requiered").build();
        }
        try {
            Map<String, Object> preparedParams = prepareParams(dateAdded, start, amount, difficulty);

            treasures = treasureDAO.get(preparedParams);
            treasures
                    .sort(
                            (o1, o2) -> distance(coordinateX, coordinateY, o1)
                                    .compareTo(distance(coordinateX, coordinateY, o2)));
        } catch (DAOException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        return Response.status(Response.Status.OK).entity(treasures).build();
    }

    private static Double distance(Double coordinateX, Double coordinateY, Treasure t) {
        return Math.sqrt(Math.pow(coordinateX - t.getCoordinateX(), 2)
                + Math.pow(coordinateY - t.getCoordinateY(), 2));
    }

    /**
     * @param treasureID
     * @return Response
     * @throws DAOException
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{treasureId}")
    public Response getUser(@PathParam("treasureId") String treasureId) throws DAOException {
        Treasure treasure = null;
        try {
            treasure = treasureDAO.getOne(Integer.parseInt(treasureId));
        } catch (DAOException e) {
            throw new DAOException("Failed to get the treasure");
        }
        if (treasure == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.status(Response.Status.OK).entity(treasure).build();
    }
}
