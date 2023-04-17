package com.geoetsiinf.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.geoetsiinf.dao.DAOException;
import com.geoetsiinf.dao.manager.DAOManager;
import com.geoetsiinf.dao.profile.ProfileDAO;
import com.geoetsiinf.models.Profile;


@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileResource {

    private DAOManager manager = new DAOManager();
    private ProfileDAO profileDAO = manager.getProfileDAO();

    @GET
    public Response getAll(@PathParam("userName") String userName) throws DAOException {
        Profile userProfile = null;
        userProfile = profileDAO.get(userName);
        return Response.status(Response.Status.OK).entity(userProfile).build();
    }
    
}
