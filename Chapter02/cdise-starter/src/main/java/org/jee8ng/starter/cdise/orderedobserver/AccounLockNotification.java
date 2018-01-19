package org.jee8ng.starter.cdise.orderedobserver;

import javax.annotation.Priority;
import javax.enterprise.event.Observes;

/**
 *
 * @author prashantp.org
 */
public class AccounLockNotification {
   
    public void sendSmsOnAccountLock(@Observes @Priority(2) LoginEvent event) {
        if(event.isLockAccount() == false) return;
        sendAccountLockSms(event.getUserId());
    }   
    
    private void sendAccountLockSms(String userId) {
        System.out.println("SMS to user " + userId);
    }
}
