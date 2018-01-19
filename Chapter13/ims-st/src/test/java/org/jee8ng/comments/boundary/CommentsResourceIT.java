/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jee8ng.comments.boundary;

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
public class CommentsResourceIT {
    private Client client;
    private WebTarget targetAPI;

    @Before
    public void init() {
        this.client = ClientBuilder.newClient();
        this.targetAPI = this.client.target("http://localhost:8083/ims-comments/resources/comments/{issueid}");
    }

    @Test
    public void setup() {
        JsonObject comment = Json.createObjectBuilder()
                .add("text", "Who can fix this?")
                .add("byUser", 1L)
                .build();
        Response initiallyCreated = this.targetAPI
                .resolveTemplate("issueid", 1L)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(comment));
        assertThat(initiallyCreated.getStatus(), is(201));
        String location = initiallyCreated.getHeaderString("Location");
        assertNotNull(location);
        
        Response evenCreated = this.client.target(location).
                request(MediaType.APPLICATION_JSON).
                get();
        assertThat(evenCreated.getStatus(), is(200));
        
        comment = Json.createObjectBuilder()
                .add("text", "I can fix this")
                .add("byUser", 2L)
                .build();
        
        initiallyCreated = this.targetAPI
                .resolveTemplate("issueid", 1L)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(comment));
        location = initiallyCreated.getHeaderString("Location");
        assertNotNull(location);
        
        evenCreated = this.client.target(location).
                request(MediaType.APPLICATION_JSON).
                get();
        assertThat(evenCreated.getStatus(), is(200));       
        
    }
}
