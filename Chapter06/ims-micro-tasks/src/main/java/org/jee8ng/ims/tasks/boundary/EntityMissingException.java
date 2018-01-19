package org.jee8ng.ims.tasks.boundary;

/**
 *
 * @author prashantp.org
 */
public class EntityMissingException extends RuntimeException {
    
    public EntityMissingException(String msg) {
        super(msg);
    }
}
