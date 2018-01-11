/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jee8ng.issues.boundary;

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
public class IssuesResourceIT {

    private Client client;
    private WebTarget targetAPI;

    @Before
    public void init() {
        this.client = ClientBuilder.newClient();
        this.targetAPI = this.client.target("http://localhost:8082/ims-issues/resources/issues");
    }

    @Test
    public void setup() {
        JsonObject user = Json.createObjectBuilder()
                .add("label", "Fix Bug A")
                .add("description", "Bug A is critical for product")
                .add("assignedTo", user(1L, "marcus"))
                .build();
        Response initiallyCreated = this.targetAPI.request(MediaType.APPLICATION_JSON).post(Entity.json(user));
        assertThat(initiallyCreated.getStatus(), is(201));
        String location = initiallyCreated.getHeaderString("Location");
        assertNotNull(location);
        
        Response evenCreated = this.client.target(location).
                request(MediaType.APPLICATION_JSON).
                get();
        assertThat(evenCreated.getStatus(), is(200));
        
        user = Json.createObjectBuilder()
                .add("label", "Fix Bug B")
                .add("description", "Bug B needs attention")
                .add("assignedTo", user(2L, "bob"))
                .build();
        initiallyCreated = this.targetAPI.request(MediaType.APPLICATION_JSON).post(Entity.json(user));
        location = initiallyCreated.getHeaderString("Location");
        assertNotNull(location);
        
        evenCreated = this.client.target(location).
                request(MediaType.APPLICATION_JSON).
                get();
        assertThat(evenCreated.getStatus(), is(200));       
        
    }
    
    private JsonObject user(Long id, String username) {
        return Json.createObjectBuilder()
                .add("id", id)
                .add("name", username)
                .build();
    }
}
