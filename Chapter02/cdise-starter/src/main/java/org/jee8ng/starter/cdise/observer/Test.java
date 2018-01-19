package org.jee8ng.starter.cdise.observer;

import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.inject.Inject;

/**
 *
 * @author prashantp.org
 */
public class Test {

    @Inject
    private Event<Task> event;

    public void doSomething() {
        //Raise an event containg Task instance as payload
        event.fire(new Task("observer works"));
    }
    
    public static void main(String... args) {
        try (SeContainer container = SeContainerInitializer
                .newInstance().initialize()) {
            Test appInstance = container
                    .select(Test.class)
                    .get();
            //Invoke action which raises an event that an observer listens to
            appInstance.doSomething();
        }
    }
}

//POJO class acts as the payload
class Task {
    private String name;
    
    Task() {}
    Task(String name) { this.name = name; }
}

//A observer class
class TaskObserver {
    //Listens to raised Task events
    public void handle(@Observes Task task) {
        System.out.println("found a task: " + task);
    }
}
