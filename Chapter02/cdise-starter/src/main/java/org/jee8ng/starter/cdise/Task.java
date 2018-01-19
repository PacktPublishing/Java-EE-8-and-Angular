package org.jee8ng.starter.cdise;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.control.ActivateRequestContext;
import javax.enterprise.context.control.RequestContextController;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.inject.Inject;

/* Simple POJO */
@RequestScoped
class LoginBean { 
    LoginBean() {
        System.out.println("new LoginBean created");
    }
}

/* Simple POJO */
class TaskPersistence { 
    TaskPersistence() {
        System.out.println("new TaskPersistence created");
    }
}

/**
 *
 * @author prashantp.org
 */
@ApplicationScoped
public class Task {
    @Inject
    private LoginBean bean;
    
    //Injection done at construction point using CDI
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
        System.out.println("RequestContextController - found LoginBean: " + this.bean );
        
        if(activated) requestContextController.deactivate();
    }
    
    
    /*
    Interceptor Binding activates request scope, thus LoginBean is injected
    */
    @ActivateRequestContext
    public void doWorkInRequest() {
        System.out.println("ActivateRequestContext - found LoginBean: " + this.bean);
    }
    
    public static void main(String... args) {
        try (SeContainer container = SeContainerInitializer
                .newInstance().initialize()) {
            Task appInstance = container
                    .select(Task.class)
                    .get();
            //Test normal CDI
            appInstance.useInjected();
            
            //Test programmatic approach using RequestContextController
            //For each of below requests a new LoginBean is injected
            appInstance.doWorkInRequest("programmatic");            
            appInstance.doWorkInRequest("programmatic");
            
            //Test annotation approach using @ActivateRequestContext
            //For each of below requests a new LoginBean is injected
            appInstance.doWorkInRequest();
            appInstance.doWorkInRequest();
        }
    }
}
