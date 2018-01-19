package org.jee8ng.users.boundary;

import static io.restassured.RestAssured.when;
import java.net.URL;
import java.util.Optional;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jee8ng.users.entity.Credential;
import org.jee8ng.users.entity.User;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Integration tests
 * @author prashantp.org
 */
@RunWith(Arquillian.class)
public class UsersServiceTest {

    @Inject
    private UsersService service;

    @Deployment(testable=false)
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "ims-users.war")
                .addPackages(true, "org.jee8ng.users")
                .addPackages(true, "org.jee8ng.security")
                .addAsWebInfResource("beans.xml")
                .addAsWebInfResource("web.xml")
                .addAsResource("persistence.xml",
                        "META-INF/persistence.xml");
    }

    @Test
    public void testCreateUser(@ArquillianResource URL resource) throws Exception {
        URL apiUrl = new URL(resource, "resources/users");
        JsonObject user = Json.createObjectBuilder()
                .add("name", "Marcus")
                .add("email", "marcus_1982@jee8ng.org")
                .add("credential", credential("marcus", "1234"))
                .build();

        Response initiallyCreated = ClientBuilder.newClient().target(apiUrl.toURI())
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(user));
        assertThat(initiallyCreated.getStatus(), is(201));

        String location = initiallyCreated.getHeaderString("Location");
        assertNotNull(location);
    }

    private JsonObject credential(String username, String password) {
        return Json.createObjectBuilder()
                .add("username", username)
                .add("password", password)
                .build();
    }

    @Test
    public void testGetUsers(@ArquillianResource URL resource) throws Exception {
        URL obj = new URL(resource, "resources/users");
//        Response resp = ClientBuilder.newClient().target(obj.toURI())
//				.request(MediaType.APPLICATION_JSON).get();
//        assertThat(resp.getStatus(), is(200));

        when().get(obj.toURI()).then()
                .statusCode(200);
        
//                .body("id", is(1));

    }

//    @Test
//    public void testUserSaved() {
//        User user = new User();
//        user.setEmail("test@tt.com");
//        user.setName("test");
//        user.setCredential(new Credential("testtt","testing123"));
//        service.add(user);
//        final Optional<User> dbUser = service.get(user.getId());
//        
//        assertTrue("user saved", dbUser.isPresent());
//        
//        assertThat(dbUser.get().getEmail(), equalTo("test@tt.com"));
//        
//    }
}
