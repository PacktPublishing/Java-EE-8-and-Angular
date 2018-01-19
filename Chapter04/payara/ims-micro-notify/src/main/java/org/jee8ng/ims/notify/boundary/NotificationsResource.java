package org.jee8ng.ims.notify.boundary;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 *
 * @author prashantp.org
 */
@Path("notifications")
public class NotificationsResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        return Response.ok("notification works").build();
    }
}
