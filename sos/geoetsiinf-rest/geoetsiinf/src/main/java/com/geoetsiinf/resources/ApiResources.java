package com.geoetsiinf.resources;

    import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.geoetsiinf.models.API;

@Path("/")
public class ApiResources {
    


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getApi() {
        API api = new API();
        return Response.status(Response.Status.OK).entity(api.getJson().toString()).build();
    }
}
