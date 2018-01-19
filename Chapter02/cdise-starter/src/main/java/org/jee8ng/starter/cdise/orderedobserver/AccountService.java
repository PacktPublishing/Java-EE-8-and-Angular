package org.jee8ng.starter.cdise.orderedobserver;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.inject.Inject;
import org.jee8ng.starter.cdise.observer.Test;

/**
 * Outputs:
        login attempt made 1
        login attempt made 2
        login attempt made 3
        Account is locked
        SMS to user AG007
* 
 * @author prashantp.org
 */
@ApplicationScoped
public class AccountService {
    
    @Inject 
    private Event<LoginEvent> event;

    public void login(int attemptsMadeCount, String byUserId) {
        System.out.println("login attempt made " + attemptsMadeCount);
        event.fire(new LoginEvent(attemptsMadeCount, byUserId ));
    }
    
    public static void main(String[] args) {
        try (SeContainer container = SeContainerInitializer
                .newInstance().initialize()) {
            AccountService appInstance = container
                    .select(AccountService.class)
                    .get();
            
            appInstance.login(1,"AG007");
            appInstance.login(2,"AG007");
            //3rd event should lock account and then send SMS
            appInstance.login(3,"AG007");
        }
    }
}
