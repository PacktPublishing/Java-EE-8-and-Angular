/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.prashantp.starter.cdise.orderedobserver;

/**
 *
 * @author prashantp
 */
public class LoginEvent {
    private final Integer attemptsMade;
    private final String userId;
    private boolean lockAccount = false;
   
    public LoginEvent(Integer count, String userId) {
        this.attemptsMade = count;
        this.userId = userId;
    }

    public Integer getAttemptsMade() {
        return attemptsMade;
    }

    public String getUserId() {
        return userId;
    }

    public boolean isLockAccount() {
        return lockAccount;
    }

    public void setLockAccount(boolean lockAccount) {
        this.lockAccount = lockAccount;
    }
    
}
