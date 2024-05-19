package org.can.armagan.jwttokenservice.model.request;

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
