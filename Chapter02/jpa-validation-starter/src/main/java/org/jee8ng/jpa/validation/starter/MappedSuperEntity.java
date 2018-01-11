/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jee8ng.jpa.validation.starter;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author prashantp
 */
@MappedSuperclass
public class MappedSuperEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    protected Long id; 
    
    
}
