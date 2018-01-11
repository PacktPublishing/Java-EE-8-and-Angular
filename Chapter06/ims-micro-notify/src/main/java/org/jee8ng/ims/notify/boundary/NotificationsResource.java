/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jee8ng.ims.notify.boundary;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jee8ng.ims.notify.entity.Ticket;

/**
 *
 * @author prashantp
 */
@Path("notifications")
public class NotificationsResource {
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response getXML() {
        return Response.ok(new Ticket(1, "Fix slow loading")).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        return Response.ok(new Ticket(1, "Fix slow loading")).build();
    }
    
}
