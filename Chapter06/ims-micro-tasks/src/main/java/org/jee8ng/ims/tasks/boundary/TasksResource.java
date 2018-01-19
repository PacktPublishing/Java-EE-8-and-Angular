package org.jee8ng.ims.tasks.boundary;

import java.net.URI;
import java.util.UUID;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonPatch;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.jee8ng.ims.tasks.entity.TaskUpdated;

/**
 *
 * @author prashantp.org
 */
@Path("tasks")
public class TasksResource {
    private static long i = 0;
    
    @Inject
    private Event<TaskUpdated> event;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {        
        if(true) {
            //Simulate an exception scenario
            throw new EntityMissingException("missing task");
        }        
        return Response.ok().build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(Task newTask) {
        newTask.setId(newTask.getName().length() * 2L);

        //Raise random data for event
        event.fire(new TaskUpdated(1L, 0L));

        return Response.ok().build();
    }

    // Some examples of adding tasks
    
    @POST
    @Path("add2")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add2(Task newTask, @Context UriInfo uriInfo) {
        newTask.setId(newTask.getName().length() * 2L);
        
        URI location = uriInfo.getAbsolutePathBuilder()
                .path(newTask.getId().toString())
                .build();
        
        return Response.created(location).build();
    }
    
    @POST
    @Path("add3")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Valid
    public Response add3(@NotNull Task newTask) {
        newTask.setId(newTask.getName().length() * 2L);

//    		URI location = uriInfo.getAbsolutePathBuilder()
//    					.path(newTask.getId().toString())
//    					.build();
        return Response.ok().build();
    }
    
    @PATCH
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON_PATCH_JSON)
    public Response patch(@PathParam("id") Long id, JsonPatch patch) {
        JsonObject json = Json.createObjectBuilder()
                .add("id", "11")
                .add("name", "test").build();
        System.out.println("json: " + json);
        
//      We could have created a patch like this too.  
//      JsonPatch patch = Json.createPatch(patchArray);

        System.out.println("patch: " + patch);
        JsonObject updatedJson = patch.apply(json);
        System.out.println("updated: " + updatedJson);
        return Response.ok(updatedJson).build();
    }
}
