/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jee8ng.ims.tasks.boundary;

/**
 *
 * @author prashantp
 */
public class EntityMissingException extends RuntimeException {
    
    public EntityMissingException(String msg) {
        super(msg);
    }
}
