package org.jee8ng.ims.users.boundary;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author prashantp.org
 */
@Provider
public class ResourceExceptionMapper implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable exception) {
        if(exception instanceof IllegalArgumentException) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.serverError().build();
    }
    
}
