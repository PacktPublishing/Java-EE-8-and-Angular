/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.prashantp.starter.cdise;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

/**
 *
 * @author prashantp
 */
public class BootCDI {

    public void doSomething() {
        System.out.println("do something called");
    }

    public static void main(String... args) {
        try (SeContainer container = SeContainerInitializer
                .newInstance().initialize()) {
            BootCDI appInstance = container
                    .select(BootCDI.class)
                    .get();
            appInstance.doSomething();
        }
    }
}
