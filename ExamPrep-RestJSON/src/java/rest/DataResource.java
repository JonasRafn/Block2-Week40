package rest;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import utilities.DataGenerator;

@Path("data")
public class DataResource {

    @Context
    private UriInfo context;

    public DataResource() {
    }

    @GET
    @Path("{num: [0-9]+}/{str}")
    @Produces("application/json")
    public Response getJson(@PathParam("num") int num, @PathParam("str") String types) {

        String data = DataGenerator.generateData(num, types);

        return Response
                .status(Response.Status.OK)
                .header("Access-Control-Allow-Origin", "*")
                .entity(data)
                .build();

    }

}
