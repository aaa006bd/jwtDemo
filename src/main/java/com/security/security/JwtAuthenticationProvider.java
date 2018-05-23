package com.security.security;

import com.security.model.JwtUser;
import com.security.model.JwtUserDetails;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Abdullah Al Amin on 5/23/2018.
 */
@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    private JwtValidator validator;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails,
                                                  UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return null;
    }

    @Override
    protected UserDetails retrieveUser(String username,
                                       UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) usernamePasswordAuthenticationToken;

        String token = jwtAuthenticationToken.getToken();
        JwtUser user = validator.validate(token);
        if(user == null){
            throw new RuntimeException("invalid jwt token");
        }

        List<GrantedAuthority> roles = AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRole());
        return new JwtUserDetails(user.getUsername(), user.getId(),token,roles);

    }

    @Override
    public boolean supports(Class<?> aClass) {
        return  JwtAuthenticationToken.class.isAssignableFrom(aClass);
    }
}
