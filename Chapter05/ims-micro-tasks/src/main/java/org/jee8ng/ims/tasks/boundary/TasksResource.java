package org.jee8ng.ims.tasks.boundary;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonPatch;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jee8ng.ims.tasks.entity.Ticket;

/**
 *
 * @author prashantp.org
 */
@Path("tasks")
public class TasksResource {
    
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response get() {
        return Response.ok(
                new Ticket(1, "Fix slow loading")
               ).build();
    }
    
    //Shows how to work with JSON Patch    
    @PATCH
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON_PATCH_JSON)
    public Response patch(@PathParam("id") Long id, 
                                JsonArray patchArray) {
        JsonPatch patch = Json.createPatch(patchArray);

        JsonObject jsonObject = buildJson();
        JsonObject updatedJson = patch.apply(jsonObject);
       
        return Response.ok(updatedJson).build();
    }
    
    private JsonObject buildJson() {
        JsonObject json = Json.createObjectBuilder()
                .add("name", "Raise alert on failure")
                .add("id", 2003L)
                .build();
        return json;
    }
}
