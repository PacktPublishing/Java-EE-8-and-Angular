/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jee8ng.issues.entity;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author prashantp.org
 */
@Entity
public class Issue implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonbProperty("label")
    private String name;
    private String description;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User assignedTo;
    private ZonedDateTime created;
    private ZonedDateTime modified;

    public Issue(Long id, String name, User assignedTo) {
        this.id = id;
        this.name = name;
        this.assignedTo = assignedTo;
    }

    public Issue() {        
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(User assignedTo) {
        this.assignedTo = assignedTo;
    }

    public ZonedDateTime getCreated() {
        return created;
    }

    public void setCreated(ZonedDateTime created) {
        this.created = created;
    }

    public ZonedDateTime getModified() {
        return modified;
    }

    public void setModified(ZonedDateTime modified) {
        this.modified = modified;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final Issue other = (Issue) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Issue{" + "id=" + id + ", name=" + name + ", description=" + description + ", assignedTo=" + assignedTo + ", created=" + created + ", modified=" + modified + '}';
    }

}
