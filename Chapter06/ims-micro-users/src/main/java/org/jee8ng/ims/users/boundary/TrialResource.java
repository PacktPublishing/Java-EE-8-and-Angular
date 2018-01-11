/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jee8ng.ims.users.boundary;

import java.util.concurrent.CompletionStage;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.inject.Inject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Response;
import org.jee8ng.ims.users.entity.User;

/**
 *
 * @author prashantp
 */
@Path("trials")
public class TrialResource {

    @DefaultValue("v1")
    @HeaderParam("X-version")
    private String apiVersion;

    @QueryParam("test")
    private String param1;
    
    @PathParam("id")
    private String pathParam;

    @Inject
    private UsersService service;

    @Resource
    private ManagedExecutorService mes;

    @GET
    public Response getAll() {
        System.out.println("getAll()");
        rx();
        System.out.println("rx() ends");
        return Response.ok(service.getAll()).build();
    }

    @GET
    @Path("test")
    public Response test() {
        System.out.println("calling get all starts");
        Client client = ClientBuilder.newClient();
        Response res = client.target("http://localhost:8080/ims-micro-users/resources/trials")
                .request("application/json").get();
        System.out.println("res" + res.getEntity());
        System.out.println("calling get all ended");
        return Response.ok().build();
    }

    private void rx() {
        System.out.println("rx called");
        Client client = ClientBuilder.newClient();
        WebTarget base = client.target("http://localhost:8080/ims-micro-users/resources/trials/slow");
        CompletionStage<User> csf = base.request("application/json")
                .rx()
                .get(User.class);
        System.out.println("rx get done");
        csf.thenAccept(System.out::println);
        System.out.println("accept ended");
    }

    private void syncAPICall() {
        Client client = ClientBuilder.newClient();
        WebTarget base = client.target("http://localhost:8080/ims-micro-users/resources/");
        WebTarget user = base.path("users").path("{id}");
        Response response = user.resolveTemplate("id", 12).request("application/json").get();
        System.out.println("response " + response.readEntity(User.class).getName());
    }

    private void asyncAPICall() {
        Client client = ClientBuilder.newClient();
        Future<Response> futureRsp = client.target("http://localhost:8080/ims-micro-users/resources/users")
                .request("application/json")
                .async()
                .get(new InvocationCallback<Response>() {
                    @Override
                    public void completed(Response response) {
                        //Use the response
                    }

                    @Override
                    public void failed(Throwable throwable) {
                        //Error case
                    }
                });

//        System.out.println("response " + res.get().readEntity(User.class).getName());
    }

    @GET
    @Path("slow")
    public void timeConsumingActivity(
            @Suspended final AsyncResponse ar) {
        //Some thread executor to run the job
        mes.execute(() -> {
            try {
                System.out.println("waiting");
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException ex) {
            }
            System.out.println("resumed");
            ar.resume(service.getUser(1L));
        });
    }

    private void random() {
        Client client = ClientBuilder.newClient();
        CompletionStage<Phone> csp = client.target("phones/{item}")
                .resolveTemplate("item", "android")
                .request()
                .rx()
                .get(Phone.class);
        CompletionStage<String> csf = client.target("recommendations/{item}")
                .resolveTemplate("item", "android")
                .request()
                .rx()
                .get(String.class);

        csp.thenCombine(csf, (phone, recommended)
                -> buyWhenAvailableAndRecommended(phone, recommended));
    }

    private CompletionStage<Object> buyWhenAvailableAndRecommended(Phone phone, String recommended) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    class Phone {
    }
}
