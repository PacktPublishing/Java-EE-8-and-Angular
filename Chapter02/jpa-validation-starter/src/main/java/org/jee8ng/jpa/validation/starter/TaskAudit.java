/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jee8ng.jpa.validation.starter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PostPersist;

/**
 *
 * @author prashantp
 */
public class TaskAudit {

    @PersistenceContext
    private EntityManager em;

    @PostPersist
    public void trackChanges(MappedSuperEntity entity) {
        System.out.println("PostPersist of " + entity);    
    }
}
