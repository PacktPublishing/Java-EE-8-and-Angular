package org.jee8ng.jaxrsdemo;

import java.io.IOException;
import javax.annotation.Priority;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author prashantp.org
 */
@Provider
@Priority(5)
public class CorsRespFilter2 implements ContainerResponseFilter {
 
   @Override
   public void filter(ContainerRequestContext requestContext,
                    ContainerResponseContext responseContext)
         throws IOException {
       System.out.println("CorsRespFilter2");
       System.out.println("Request filters have added " + requestContext.getPropertyNames());
      responseContext.getHeaders()
                     .add("Access-Control-Allow-Origin", "http://foo.example.com");
   }

    
}
