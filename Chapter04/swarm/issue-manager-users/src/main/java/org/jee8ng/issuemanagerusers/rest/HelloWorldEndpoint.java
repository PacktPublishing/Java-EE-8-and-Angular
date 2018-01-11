package org.jee8ng.issuemanagerusers.rest;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloWorldEndpoint {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response doGet() {
        JsonObject json = Json.createObjectBuilder()
                .add("name", "hello microservice")
                .build();
        return Response.ok(json).build();
    }
}
