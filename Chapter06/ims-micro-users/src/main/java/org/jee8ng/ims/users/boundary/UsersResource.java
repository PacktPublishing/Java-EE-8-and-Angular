package org.jee8ng.ims.users.boundary;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.net.URI;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.jee8ng.ims.users.entity.User;

/**
 *
 * @author prashantp.org
 */
@Path("users")
@Api(value = "/users")
public class UsersResource {

    @Inject
    private UsersService service;

    @GET
    @ApiOperation(value = "Get all users",
            notes = "This can only be done by the logged in user.")
    @ApiResponses(value = {
      @ApiResponse(code = 400, message = "Invalid input"),
      @ApiResponse(code = 404, message = "User not found") })
    public Response getAll() {
        return Response.ok(service.getAll()).build();
    }

    @GET
    @Path("{id}")
    public Response get(@PathParam("id") Long id) {
        System.out.println("get id: " + id);
        return Response.ok(service.getUser(id)).build();
    }

    @POST
    public Response add(User newUser, @Context UriInfo uriInfo) {
        Long newId = service.add(newUser);

        URI location = uriInfo.getAbsolutePathBuilder()
                .path(String.valueOf(newId))
                .build();

        return Response.created(location).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, User existingUser) {
        System.out.println("update id: " + id + ",existingUser " + existingUser.getName());
        service.updateIfExists(id, existingUser);

        return Response.ok(existingUser).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        System.out.println("delete id: " + id);
        service.delete(id);

        return Response.ok().build();
    }

}
