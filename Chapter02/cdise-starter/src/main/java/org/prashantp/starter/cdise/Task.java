/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.prashantp.starter.cdise;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.control.ActivateRequestContext;
import javax.enterprise.context.control.RequestContextController;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.inject.Inject;

/**
 *
 * @author prashantp
 */
@RequestScoped
class LoginBean {
}

class TaskPersistence { 
  
}

@ApplicationScoped
public class Task {
    @Inject
    private LoginBean bean;
    
    //Verify Injection using CDI
    private final TaskPersistence persistence;
   
    @Inject Task(TaskPersistence persistence) {
        this.persistence = persistence;
    }
    
    public void useInjected() {
        System.out.println("CDI Injection works = " + (this.persistence != null));
    }
    
    //Verify programmatic RequestContextController
    @Inject
    private RequestContextController requestContextController;
    
    /*
    LoginBean will be only injected when request context is active
    */
    public void doWorkInRequest(String data) {
        boolean activated = requestContextController.activate();
        //some work here
        System.out.println("Is running within the context = " + activated);
        System.out.println("found bean: " + this.bean != null);
        
        if(activated) requestContextController.deactivate();
    }
    
    
    /*
    Interceptor Binding activates request scope, thus LoginBean is injected
    */
    @ActivateRequestContext
    public void doWorkInRequest() {
        System.out.println("found bean: " + this.bean != null);
    }
    
    public static void main(String... args) {
        try (SeContainer container = SeContainerInitializer
                .newInstance().initialize()) {
            Task appInstance = container
                    .select(Task.class)
                    .get();
            //Test normal CDI
            appInstance.useInjected();
            
            //Test LoginBean injection for RequestContextController
            appInstance.doWorkInRequest("programmatic");
            
            //Test LoginBean injection for @ActivateRequestContext
            appInstance.doWorkInRequest();
        }
    }
}
