package org.jee8ng.jpa.validation.starter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PostPersist;

/**
 *
 * @author prashantp.org
 */
public class TaskAudit {

    @PersistenceContext
    private EntityManager em;

    @PostPersist
    public void trackChanges(MappedSuperEntity entity) {
        System.out.println("PostPersist of " + entity);    
    }
}
