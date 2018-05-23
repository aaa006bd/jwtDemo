package com.security.security;

import com.security.model.JwtUser;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

/**
 * Created by Abdullah Al Amin on 5/23/2018.
 */
@Component
public class JwtValidator {
    private String secret="youtube";

    public JwtUser validate(String token) {
        JwtUser user = null;

        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
            user =  new JwtUser();

            user.setUsername(body.getSubject());
            user.setId(Long.parseLong((String) body.get("userId")));
            user.setRole((String)body.get("role"));
        } catch (ExpiredJwtException e) {
            e.printStackTrace();
        }  catch (RuntimeException e) {
            e.printStackTrace();
        }

        return user;
    }
}
