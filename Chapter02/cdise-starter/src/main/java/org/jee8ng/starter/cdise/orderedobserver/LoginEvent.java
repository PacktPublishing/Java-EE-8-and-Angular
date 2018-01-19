package org.jee8ng.starter.cdise.orderedobserver;

/**
 *
 * @author prashantp.org
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
