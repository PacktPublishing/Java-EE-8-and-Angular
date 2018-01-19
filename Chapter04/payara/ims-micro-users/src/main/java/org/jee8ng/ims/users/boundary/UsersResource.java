package org.jee8ng.ims.users.boundary;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 *
 * @author prashantp.org
 */
@Path("users")
public class UsersResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        return Response.ok("user resource works").build();
    }
}
