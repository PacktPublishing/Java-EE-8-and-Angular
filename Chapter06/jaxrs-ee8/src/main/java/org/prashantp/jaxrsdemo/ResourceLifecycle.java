/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.prashantp.jaxrsdemo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Output for code:
 *
 * Info: static block Info: instance block Info: constructor Info: post
 * construct Info: 1, hashcode of this object 691770418 Info: resource method
 *
 * @author prashantp
 */
@Path("resource")
@Api(value = "/resource")
public class ResourceLifecycle {

    private int i = 1;

    static {
        System.out.println("static block");
    }

    {
        System.out.println("instance block");
    }

    public ResourceLifecycle() {
        System.out.println("constructor");
    }

    @GET
    @ApiOperation(value = "Get user",
            notes = "This can only be done by the logged in user.")
    public Response get(@HeaderParam("X-Test") String test) {
        System.out.println((i++) + ", hashcode of this object " + this.hashCode());
        System.out.println("resource method X-Test=" + test);
        return Response.ok("works").build();
    }

    @GET
    @Path("nested")
    @Produces(MediaType.APPLICATION_JSON)
    public Response nestedResource() {
        System.out.println("nested resource");
        return Response.ok("nested").build();
    }

    @PostConstruct
    private void construct() {
        System.out.println("post construct");
    }

    @PreDestroy
    private void destory() {
        System.out.println("pre destory");
    }
}
