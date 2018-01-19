package org.jee8ng.jaxrsdemo;

import java.io.IOException;
import javax.annotation.Priority;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author prashantp.org
 */
@Provider
@Priority(5)
public class RandomRequestFilter1 implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        System.out.println("setting random-1");
        requestContext.setProperty("random-1", "RandomRequestFilter1");
    }
 
    
}
