package org.jee8ng.issues.boundary;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class IssuesSteps {

    private WebTarget targetAPI;
    private Response resp;

    @Given("^issues api is up and running$")
    public void given() throws Throwable {
        Client client = ClientBuilder.newClient();
        this.targetAPI = client.target("http://localhost:8082/ims-issues/resources/issues");
    }

    @When("^a request to the Issue listing is made$")
    public void when() throws Throwable {
        this.resp = this.targetAPI.request(MediaType.APPLICATION_JSON).get();

    }

    @Then("^a list of issues should be returned with (\\d+) status code$")
    public void then(int status) throws Throwable {
        assertThat(resp.getStatus(), is(status));
    }

}
