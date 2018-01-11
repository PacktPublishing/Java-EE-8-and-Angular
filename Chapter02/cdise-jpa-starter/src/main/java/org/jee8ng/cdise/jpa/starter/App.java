/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jee8ng.cdise.jpa.starter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.validation.ConstraintViolationException;

/**
 *
 * @author prashantp
 */
@ApplicationScoped
public class App {

    @Inject
    private EntityManager em;

    public void doCRUD() {
        System.out.println("======== Single Task CRUD =============");
        save(100L, "Work on next big thing");
        read(100L);
        update(100L);
        remove(100L);
        read(100L);
        
        System.out.println("======== Task Read Options =============");
        save(201L, "Fix Bug A");
        save(202L, "Fix Bug B");
        
        readAll();
        readStream();
    }

    private void readStream() {
        TypedQuery<Task> query = em.createQuery("SELECT t from Task t",
                Task.class);
        List<String> names = query.getResultStream().map(Task::getName)
                .collect(Collectors.toList());
        System.out.println("names found " + names);
    }

    private void readAll() {
        TypedQuery<Task> query = em.createQuery("SELECT t FROM Task t", Task.class);
        List<Task> tasks = query.getResultList();
        System.out.println("tasks found " + tasks.size());
    }

    private void save(Long id, String name) {
        System.out.println("--------------------- save --------------------");
        em.getTransaction().begin();
        Task theTask = new Task(id, name);
        em.persist(theTask);
        em.getTransaction().commit();
        System.out.println("saved task " + theTask);
    }

    private void read(Long id) {
        System.out.println("--------------------- read --------------------");
        TypedQuery<Task> query = em.createNamedQuery("Task.findById", Task.class);
        query.setParameter("id", id);

        //With TypedQuery you don't need a cast to Task type below
        try {
            Task task = query.getSingleResult();
            System.out.println("task found " + task);
        } catch (NoResultException nre) {
            System.out.println("task not found ");
        }

    }

    private void update(Long id) {
        System.out.println("--------------------- update --------------------");
        em.getTransaction().begin();
        Task theTask = em.find(Task.class, id);
        theTask.setAssignedon(LocalDate.of(2018, 7, 21));
        em.getTransaction().commit();

        Task theUpdatedTask = em.find(Task.class, 100L);
        System.out.println("theUpdatedTask assignedon " + theUpdatedTask.getAssignedon());
    }

    private void remove(Long id) {
        System.out.println("--------------------- remove --------------------");
        em.getTransaction().begin();
        Task theTask = em.find(Task.class, id);
        em.remove(theTask); // theTask is a reference to Task object
        em.getTransaction().commit();
        System.out.println("removed task");
    }

    private void trySaveInvalid() {
        Task theTask = new Task();
        theTask.setName("A longer name than allowed");
        try {
            em.persist(theTask);
        } catch (ConstraintViolationException violation) {
            violation.getConstraintViolations().forEach(
                    v -> System.out.println("violation " + v)
            );
        }
    }

    public static void main(String[] args) {
        try (SeContainer container = SeContainerInitializer
                .newInstance().initialize()) {
            App appInstance = container
                    .select(App.class)
                    .get();
            appInstance.doCRUD();
        }
    }
}
