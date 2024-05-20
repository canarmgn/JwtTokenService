package org.can.armagan.jwttokenservice.service;

import lombok.RequiredArgsConstructor;
import org.can.armagan.jwttokenservice.model.request.AuthRequest;
import org.can.armagan.jwttokenservice.jwt.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor // Gerekli parametrelerle contructur oluşturur. Autowired yerine bu anotasyonla inject edilir.
public class LoginService {

    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService userDetailsService;

    public String login(AuthRequest authRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        } catch (BadCredentialsException ex) {
            throw new BadCredentialsException("Incorrect username or password", ex);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
        return jwtUtil.generateToken(userDetails);
    }
}
