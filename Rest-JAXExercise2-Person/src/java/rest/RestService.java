package rest;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import control.Control;
import entity.Person;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

@Path("person")
public class RestService {

    Gson gson;
    
    @Context
    private UriInfo context;

    public RestService() {
    }

    @GET
    @Produces("application/json")
    public String getJson() {
        return null;
    }

    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
