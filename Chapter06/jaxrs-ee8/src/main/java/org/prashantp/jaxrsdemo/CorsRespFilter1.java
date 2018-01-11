/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.prashantp.jaxrsdemo;

import java.io.IOException;
import javax.annotation.Priority;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author prashantp
 */
@Provider
@Priority(6)
public class CorsRespFilter1 implements ContainerResponseFilter {
 
   @Override
   public void filter(ContainerRequestContext requestContext,
                    ContainerResponseContext responseContext)
         throws IOException {
      System.out.println("CorsRespFilter1");
       System.out.println("Request filters have added " + requestContext.getPropertyNames());
      responseContext.getHeaders()
                     .add("Access-Control-Allow-Origin", "http://bar.example.com");
   }

    
}
