package org.jee8ng.starter.cdise;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

/**
 * A simple class showcasing how CDI can be used in Java SE
 *
 * @author prashantp.org
 */
public class BootCDI {

    /*
    * Dummy method
    */
    public void doSomething() {
        System.out.println("do something called");
    }

    public static void main(String... args) {
        //Use try-with-resources for closing the SeContainer instance
        try (SeContainer container = SeContainerInitializer
                .newInstance().initialize()) {
            //Lookup the BootCDI instance by its type.
            BootCDI appInstance = container
                    .select(BootCDI.class)
                    .get();
            //Once BootCDI instance is obtained we can invoke its methods
            appInstance.doSomething();
        }
    }
}
