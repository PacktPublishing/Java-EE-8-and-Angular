/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jee8ng.cdise.jpa.starter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author prashantp
 */
@Entity
@Table(name = "task_detail")
@NamedQuery(name = "Task.findById", 
            query = "SELECT t FROM Task t WHERE t.id = :id")
@NamedQuery(name = "Task.findByName", 
            query = "SELECT t FROM Task t WHERE t.name = :name")
public class Task implements Serializable {

    @Id
    private Long id;
    private String name;
    private LocalDate assignedon;
    private LocalDateTime createdon;
    @Column(name = "last_modified")
    private LocalDateTime lastModified;

    public Task() {}
    public Task(Long id, String name) {
        this.id = id;
        this.name = name;
        this.createdon = LocalDateTime.now();
        this.lastModified = LocalDateTime.now();
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getAssignedon() {
        return assignedon;
    }

    public void setAssignedon(LocalDate assignedon) {
        this.assignedon = assignedon;
    }

    public LocalDateTime getCreatedon() {
        return createdon;
    }

    public void setCreatedon(LocalDateTime createdon) {
        this.createdon = createdon;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Task other = (Task) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", name=" + name + ", assignedon=" + assignedon + ", createdon=" + createdon + '}';
    }

}
