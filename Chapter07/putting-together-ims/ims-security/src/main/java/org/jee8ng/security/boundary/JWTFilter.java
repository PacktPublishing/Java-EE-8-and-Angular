package org.jee8ng.security.boundary;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.io.IOException;
import java.security.Key;
import javax.annotation.Priority;
import javax.crypto.spec.SecretKeySpec;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;

/**
 * JWTFilter uses @Priority as AUTHENTICATION to get called before others
 * 
 * @author prashantp.org
 */
@Provider
@JWTRequired
@Priority(Priorities.AUTHENTICATION)
public class JWTFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String header = requestContext
                .getHeaderString(HttpHeaders.AUTHORIZATION);
        //check if request header has the token
        if (header == null || !header.startsWith("Bearer ")) {
            //This would result in a 401 response
            throw new NotAuthorizedException(
                    "Authorization header must be provided");
        }
        
        // Get token from the HTTP Authorization header
        String token = header.substring("Bearer".length()).trim();
        System.out.println("token found [" + token + "]");
        String user = getUserIfValid(token);
        System.out.println("user found " + user);
        //set user in context if required
    }
    
    /*
    * Parse the JWT passed using the secret key and check for the scope
    */
    private String getUserIfValid(String token) {
        Key key = new SecretKeySpec("secret".getBytes(), "DES");
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(key)
                    .parseClaimsJws(token);
            String scope = claims.getBody().get("scope", String.class);
            System.out.println("scope " + scope);
            return claims.getBody().getSubject();
        } catch (ExpiredJwtException | MalformedJwtException | SignatureException | UnsupportedJwtException | IllegalArgumentException e) {
            //don't trust the JWT!            
            throw new NotAuthorizedException("Invalid JWT");
        }
    }

}
