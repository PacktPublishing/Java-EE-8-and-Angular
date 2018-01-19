package org.jee8ng.jpa.validation.starter;

import java.util.Set;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

/**
 * This class triggers the actions on deployment in a Java EE container
 *
 * @author prashantp.org
 */
@Singleton
@Startup
public class App {

    @Inject
    Validator validator;

    @PersistenceContext
    private EntityManager em;

    @PostConstruct
    public void init() {
        System.out.println("===================== JPA VALIDATIONS ====================");
        save();
        System.out.println("===================== MANUAL VALIDATIONS ====================");
        saveWithManualValidation();
        System.out.println("===================== END ====================");
    }

    public void save() {
        try {
            Task theTask = new Task();
            theTask.setName("A longer name than allowed");
            em.persist(theTask);
        } catch (ConstraintViolationException violation) {
            violation.getConstraintViolations().forEach(
                    v -> System.out.println("JPA VALIDATION:: violation " + v)
            );
        }
    }

    public void saveWithManualValidation() {
        Task theTask = new Task();
        theTask.setName("A longer name than allowed");

        Set<ConstraintViolation<Task>> violationsFound = validator.validate(theTask);
        violationsFound.stream().map(ConstraintViolation::getMessage).forEach(System.out::println);
    }
}
