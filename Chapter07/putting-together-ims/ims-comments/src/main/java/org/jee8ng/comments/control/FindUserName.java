package org.jee8ng.comments.control;

import java.util.concurrent.TimeUnit;
import javax.json.JsonObject;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

/**
 *
 * @author prashantp.org
 */
public class FindUserName {
    
    public String getUserName(Long byUser) {
        Client client = ClientBuilder.newBuilder()
                .connectTimeout(500, TimeUnit.MICROSECONDS)
                .readTimeout(700, TimeUnit.MICROSECONDS)
                .build();
        try {
            JsonObject userJson = client.target("http://ims-users:8080/ims-users/resources/users/{id}")
                    .resolveTemplate("id", byUser)
                    .request().get(JsonObject.class);
            
            return userJson.getString("name");
        } catch (ProcessingException pe) {
            return "";
        }
    }
}
