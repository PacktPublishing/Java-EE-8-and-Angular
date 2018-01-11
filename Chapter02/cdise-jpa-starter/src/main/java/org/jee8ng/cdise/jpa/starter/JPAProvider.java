/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jee8ng.cdise.jpa.starter;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author prashantp
 */
public class JPAProvider {

    @Produces
    public EntityManager create() {
        System.out.println("producing entity manager");
        return Persistence.createEntityManagerFactory("taskDb")
                .createEntityManager();
    }

    public void close(@Disposes EntityManager em) {
        System.out.println("closing entity manager");
        em.close();
    }
}
