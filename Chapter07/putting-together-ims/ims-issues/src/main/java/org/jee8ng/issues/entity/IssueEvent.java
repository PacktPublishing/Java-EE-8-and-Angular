/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jee8ng.issues.entity;

/**
 *
 * @author prashantp
 */
public class IssueEvent {
    private Issue instance;

    public IssueEvent(Issue instance) {
        this.instance = instance;
    }

    public Issue getInstance() {
        return instance;
    }

    public void setInstance(Issue instance) {
        this.instance = instance;
    }
    
    
}
