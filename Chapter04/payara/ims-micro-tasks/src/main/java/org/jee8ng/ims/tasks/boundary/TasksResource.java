package org.jee8ng.ims.tasks.boundary;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 *
 * @author prashantp.org
 */
@Path("tasks")
public class TasksResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        return Response.ok("task works").build();
    }
}
