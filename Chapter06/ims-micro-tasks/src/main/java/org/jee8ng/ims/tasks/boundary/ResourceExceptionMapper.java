/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jee8ng.ims.tasks.boundary;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author prashantp
 */
@Provider
public class ResourceExceptionMapper implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable exception) {
        if(exception instanceof EntityMissingException) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        if(exception instanceof IllegalArgumentException) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.serverError().build();
    }
    
}
