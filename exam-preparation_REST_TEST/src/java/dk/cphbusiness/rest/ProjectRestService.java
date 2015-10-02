package dk.cphbusiness.rest;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import dk.cphbusiness.entity.Facade;
import dk.cphbusiness.entity.Project;
import dk.cphbusiness.entity.ProjectUser;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("projects")
public class ProjectRestService {

    @Context
    private UriInfo context;

    Gson gson;

    public ProjectRestService() {
        gson = new GsonBuilder().setPrettyPrinting().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create();

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createProject(String project) {
        Project p = gson.fromJson(project, Project.class);
        Facade.createProject(p);
        return Response.status(Response.Status.CREATED).type(MediaType.APPLICATION_JSON).entity(gson.toJson(p)).build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response GetAllUsers() {
        JsonArray out = new JsonArray();
        JsonObject jproject = new JsonObject();
        List<Project> projects = Facade.getAllProjects();
        for (Project project : projects) {
            jproject = makeProject(project);

            out.add(jproject);
        }
        return Response.status(Response.Status.OK).entity(out.toString()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getProject(@PathParam("id") String id) {
        return Response.status(Response.Status.OK).entity(makeProject(Facade.findProject(new Long(id))).toString()).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void assignUserToProject(String projectID, String userID) {
        JsonObject jProjectID = new Gson().fromJson(projectID, JsonObject.class);
        JsonObject jUserID = new Gson().fromJson(userID, JsonObject.class);
        Facade.assignUserToProject(jProjectID.get("projectID").getAsLong(), jUserID.get("userID").getAsLong());
    }

    private JsonObject makeProject(Project project) {
        JsonObject jproject = new JsonObject();
        jproject.addProperty("id", project.getId());
        jproject.addProperty("userName", project.getName());
        jproject.addProperty("description", project.getDescription());
        JsonArray jprojectUsers = new JsonArray();
        JsonObject user;
        for (ProjectUser projectUsers : project.getProjectUsers()) {
            user = new JsonObject();
            user.addProperty("name", projectUsers.getUserName());
            user.addProperty("id", projectUsers.getId());
            jprojectUsers.add(user);
        }
        jproject.add("projectUsers", jprojectUsers);
        return jproject;
    }

}
