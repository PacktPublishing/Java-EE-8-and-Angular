package org.prashantp.starter.cdise;

import static org.junit.Assert.assertNotNull;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

import org.junit.Test;

public class CdiTest {

    private String doSomething() {
        return "work!";
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
