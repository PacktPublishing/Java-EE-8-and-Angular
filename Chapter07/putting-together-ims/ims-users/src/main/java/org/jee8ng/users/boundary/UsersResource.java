package org.jee8ng.users.boundary;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.net.URI;
import java.util.Optional;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.jee8ng.security.boundary.TokenIssuer;
import org.jee8ng.users.entity.Credential;
import org.jee8ng.users.entity.User;

/**
 *
 * @author prashantp.org
 */
@Path("users")
@Api(value = "users")
public class UsersResource {

    @DefaultValue("v1")
    @HeaderParam("X-apiversion")
    private String apiVersion;

    @Inject
    private UsersService service;
    
    @Inject
    private TokenIssuer issuer;

    @GET
    @ApiOperation(value = "Get all users")
    public Response getAll(@QueryParam("names") String names) {
        if (names != null) {
            return Response.ok(service.getNames()).build();
        }
        return Response.ok(service.getAll()).build();
    }

    @GET
    @Path("{id}")
    @ApiOperation(value = "Get user by user id",
            response = User.class)
    @ApiResponses({
        @ApiResponse(code = 400, message = "Invalid input")
        ,
      @ApiResponse(code = 404, message = "User not found")
    })
    public Response get(@ApiParam(value = "ID of user that needs to be fetched", required = true)
            @PathParam("id") Long id) {
        System.out.println("request for " + id);
        final Optional<User> userFound = service.get(id);
        if (userFound.isPresent()) {
            return Response.ok(userFound.get()).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @ApiOperation(value = "Create user",
            notes = "This can only be done by the logged in user.")
    @ApiResponses(value = {
        @ApiResponse(code = 400, message = "Invalid user input")
        ,
        @ApiResponse(code = 201, message = "User added")})
    public Response add(@ApiParam(value = "User that needs to be added", required = true) User newUser, @Context UriInfo uriInfo) {
        service.add(newUser);
        return Response.created(getLocation(uriInfo, newUser.getId())).build();
    }

    @Path("/authenticate")
    @POST
    @ApiOperation(value = "Authenticate user",
            notes = "Validate and issue token to user.")
    @ApiResponses(value = {
        @ApiResponse(code = 400, message = "Invalid credentials input")
        ,
        @ApiResponse(code = 200, message = "Token issued")})
    public Response authenticate(@ApiParam(value = "User that needs to be authenticated", required = true) Credential creds) {
        boolean valid = service.isValid(creds.getUsername(), creds.getPassword());
        
        if (valid) {
            String token = issuer.issueToken(creds.getUsername());
            return Response.ok(token).build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }

    @PUT
    @Path("{id}")
    @ApiOperation(value = "Update user", response = User.class)
    @ApiResponses(value = {
        @ApiResponse(code = 400, message = "Invalid user input")
        ,
      @ApiResponse(code = 404, message = "User not found")
        ,
      @ApiResponse(code = 200, message = "User updated")})
    public Response update(@ApiParam(value = "ID of user that needs to be updated",
            required = true)
            @PathParam("id") Long id,
            @ApiParam(value = "User that needs to be updated", required = true) User updated) {
        updated.setId(id);
        boolean done = service.update(updated);

        return done
                ? Response.ok(updated).build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("{id}")
    @ApiOperation(value = "Remove the user")
    public Response remove(@ApiParam(value = "ID of user that needs to be removed",
            required = true)
            @PathParam("id") Long id) {
        service.remove(id);
        return Response.ok().build();
    }

    URI getLocation(UriInfo uriInfo, Long id) {
        return uriInfo.getAbsolutePathBuilder().path("" + id).build();
    }
}
