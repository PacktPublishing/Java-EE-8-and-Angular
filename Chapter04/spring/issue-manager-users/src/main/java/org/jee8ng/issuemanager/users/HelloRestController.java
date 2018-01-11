/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jee8ng.issuemanager.users;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author prashantp
 */
@RestController
@RequestMapping("/hello")
public class HelloRestController {
    
    @RequestMapping("")
    public String get() {
        return "hello microservice";
    }
   
}
