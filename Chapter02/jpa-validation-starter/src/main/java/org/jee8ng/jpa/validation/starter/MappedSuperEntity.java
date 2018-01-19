package org.jee8ng.jpa.validation.starter;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author prashantp.org
 */
@MappedSuperclass
public class MappedSuperEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    protected Long id; 
    
    
}
