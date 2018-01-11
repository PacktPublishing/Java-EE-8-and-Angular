/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jee8ng.ims.tasks.boundary;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 *
 * @author prashantp
 */
@Path("tasks")
public class TasksResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        return Response.ok("task works").build();
    }
}
