/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jee8ng.ims.tasks.entity;

/**
 *
 * @author prashantp
 */
public class TaskUpdated {
    private Long open;
    private Long closed;

    public TaskUpdated(Long open, Long closed) {
        this.open = open;
        this.closed = closed;
    }
    
    public TaskUpdated() {}

    public Long getOpen() {
        return open;
    }

    public void setOpen(Long open) {
        this.open = open;
    }

    public Long getClosed() {
        return closed;
    }

    public void setClosed(Long closed) {
        this.closed = closed;
    }

}
