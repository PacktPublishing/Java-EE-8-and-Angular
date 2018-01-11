/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.prashantp.starter.cdise.orderedobserver;

import javax.annotation.Priority;
import javax.enterprise.event.Observes;

/**
 *
 * @author prashantp
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
