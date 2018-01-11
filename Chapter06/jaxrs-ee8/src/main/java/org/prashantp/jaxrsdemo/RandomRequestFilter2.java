/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.prashantp.jaxrsdemo;

import java.io.IOException;
import javax.annotation.Priority;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author prashantp
 */
@Provider
@Priority(6)
public class RandomRequestFilter2 implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        System.out.println("filter 1 says " + requestContext.getProperty("random-1"));
        requestContext.setProperty("random-2", "RandomRequestFilter2");
    }
 
    
}
