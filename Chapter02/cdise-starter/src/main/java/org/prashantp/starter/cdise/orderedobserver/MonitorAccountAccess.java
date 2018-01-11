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
public class MonitorAccountAccess {
    public static final Integer MAX_ATTEMPTS = 3;
   
    public void lockForFailedAttempts(
            @Observes @Priority(1) LoginEvent event) {
        if(event.getAttemptsMade() >= MAX_ATTEMPTS) {
            event.setLockAccount(true);
            System.out.println("Account is locked");
            //do more work to push status in database
        }
    }
}
