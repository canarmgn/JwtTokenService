package org.can.armagan.jwttokenservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class AuthRequest {

    private String username;
    private String password;

}
