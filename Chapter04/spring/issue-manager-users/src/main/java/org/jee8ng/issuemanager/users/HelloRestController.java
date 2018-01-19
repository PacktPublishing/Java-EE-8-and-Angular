package org.jee8ng.issuemanager.users;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author prashantp.org
 */
@RestController
@RequestMapping("/hello")
public class HelloRestController {
    
    @RequestMapping("")
    public String get() {
        return "hello microservice";
    }
   
}
