package org.jee8ng.starter.cdise;

import static org.junit.Assert.assertNotNull;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import org.junit.Test;

/**
 *
 * @author prashantp.org
 */
public class CdiTest {

    private String doSomething() {
        return "works!";
    }

    @Test
    public void injection_test() {
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            CdiTest appInstance = container.select(CdiTest.class).get();
            String msg = appInstance.doSomething();

            assertNotNull(msg);
        }
    }
}
