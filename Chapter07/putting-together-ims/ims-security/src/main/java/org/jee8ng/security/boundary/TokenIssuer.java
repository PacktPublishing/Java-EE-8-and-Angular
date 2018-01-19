package org.jee8ng.security.boundary;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import javax.crypto.spec.SecretKeySpec;

/**
 * A utility class used to issue a JWT
 * 
 * @author prashantp.org
 */
public class TokenIssuer {
    //Set token validtity to 60mins from issued time
    public static final long EXPIRY_MINS = 60L;

    //Issue token for given username
    public String issueToken(String username) {
        //Exiration requires a Date, so use below to get the Date instance
        LocalDateTime expiryPeriod = LocalDateTime.now().plusMinutes(EXPIRY_MINS);
        Date expirationDateTime = Date.from(
                expiryPeriod.atZone(ZoneId.systemDefault())
                        .toInstant());
        //Use "secret" to generate a JWT
        Key key = new SecretKeySpec("secret".getBytes(), "DES");
        String compactJws = Jwts.builder()
                .setSubject(username) // The subject will be the username itself
                .claim("scope", "admin approver") //Can be used to set roles
                .signWith(SignatureAlgorithm.HS256, key) // The alg used
                .setIssuedAt(new Date())
                .setExpiration(expirationDateTime) //Expire token after this
                .compact();
        return compactJws;
    }
}
