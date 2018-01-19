/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jee8ng.issues.boundary;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 *
 * @author prashantp
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber"},
        features = {"classpath:feature"},
        tags = { "@call_test" }
//    features = {"src/test/resources/feature"}
)
public class RunCucumberTest {
//get("/lotto").then().assertThat().body("lotto.lottoId", equalTo(5));
    
//    given().
//    param("key1", "value1").
//    param("key2", "value2").
//when().
//    post("/somewhere").
//then().
//    body(containsString("OK"));
}
