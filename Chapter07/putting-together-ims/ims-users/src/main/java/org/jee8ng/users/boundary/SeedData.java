package org.jee8ng.users.boundary;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import org.jee8ng.users.entity.Credential;
import org.jee8ng.users.entity.User;

/**
 *
 * @author prashantp.org
 */
@Singleton
@Startup
public class SeedData {
    
    @Inject
    private UsersService service;
    
    @PostConstruct
    public void init() {
        //Dummy accounts
        User adminUser = new User();
        adminUser.setCredential(new Credential("admin", "admin"));
        adminUser.setEmail("admin@jee8ngtest.com");
        adminUser.setName("Admin");
        service.add(adminUser);
        
        User guestUser = new User();
        guestUser.setCredential(new Credential("guest", "guest"));
        guestUser.setEmail("guest@jee8ngtest.com");
        guestUser.setName("Guest");
        
        service.add(guestUser);
    }
}
