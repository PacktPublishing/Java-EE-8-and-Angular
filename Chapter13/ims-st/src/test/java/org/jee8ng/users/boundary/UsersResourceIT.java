/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jee8ng.users.boundary;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author prashantp
 */
public class UsersResourceIT {

    private Client client;
    private WebTarget tut;

    @Before
    public void init() {
        this.client = ClientBuilder.newClient();
        this.tut = this.client.target("http://localhost:8081/ims-users/resources/users");
    }

    @Test
    public void setup() {
        JsonObject user = Json.createObjectBuilder()
                .add("name", "Marcus")
                .add("email", "marcus_1982@jee8ng.org")
                .add("credential", credential("marcus", "1234"))
                .build();
        Response initiallyCreated = this.tut.request(MediaType.APPLICATION_JSON).post(Entity.json(user));
        assertThat(initiallyCreated.getStatus(), is(201));
        String location = initiallyCreated.getHeaderString("Location");
        assertNotNull(location);
        
        Response evenCreated = this.client.target(location).
                request(MediaType.APPLICATION_JSON).
                get();
        assertThat(evenCreated.getStatus(), is(200));
        
        user = Json.createObjectBuilder()
                .add("name", "Bob")
                .add("email", "bob@jee8ng.org")
                .add("credential", credential("bob", "1234"))
                .build();
        initiallyCreated = this.tut.request(MediaType.APPLICATION_JSON).post(Entity.json(user));
        location = initiallyCreated.getHeaderString("Location");
        assertNotNull(location);
        
        evenCreated = this.client.target(location).
                request(MediaType.APPLICATION_JSON).
                get();
        assertThat(evenCreated.getStatus(), is(200));       
        
    }

    private JsonObject credential(String username, String password) {
        return Json.createObjectBuilder()
                .add("username", username)
                .add("password", password)
                .build();
    }
}
