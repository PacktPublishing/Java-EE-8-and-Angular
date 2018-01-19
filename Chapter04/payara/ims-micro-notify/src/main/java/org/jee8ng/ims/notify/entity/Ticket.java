package org.jee8ng.ims.notify.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author prashantp.org
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Ticket {

    private int id;
    private String name;
    
    public Ticket() {}

    public Ticket(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
