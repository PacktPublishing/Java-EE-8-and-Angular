/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.prashantp.starter.cdise.observer;

import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.inject.Inject;

/**
 *
 * @author prashantp
 */
public class Test {

    @Inject
    Event<Task> event;

    public void doSomething() {
        event.fire(new Task("observer works"));
    }
    
    public static void main(String... args) {
        try (SeContainer container = SeContainerInitializer
                .newInstance().initialize()) {
            Test appInstance = container
                    .select(Test.class)
                    .get();
            
            appInstance.doSomething();
        }
    }
}

//POJO class
class Task {
    private String name;
    
    Task() {}
    Task(String name) { this.name = name; }
}

//A observer class
class TaskObserver {

    public void handle(@Observes Task task) {
        System.out.println("found a task: " + task);
    }
}
