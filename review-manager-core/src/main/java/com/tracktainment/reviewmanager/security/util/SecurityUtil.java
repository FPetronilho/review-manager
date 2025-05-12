package com.tracktainment.reviewmanager.security.util;

import com.tracktainment.reviewmanager.exception.AuthenticationFailedException;
import com.tracktainment.reviewmanager.security.context.DigitalUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SecurityUtil {

    public DigitalUser getDigitalUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !(authentication.getPrincipal() instanceof Jwt jwt)) {
            throw new AuthenticationFailedException("JWT not found in security context.");
        }

        DigitalUser digitalUser = new DigitalUser();
        digitalUser.setId(jwt.getSubject());
        return digitalUser;
    }
}
