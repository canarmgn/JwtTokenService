package org.can.armagan.jwttokenservice.controller;

import lombok.RequiredArgsConstructor;
import org.can.armagan.jwttokenservice.model.request.AuthRequest;
import org.can.armagan.jwttokenservice.service.LoginService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public String creteToken(@RequestBody AuthRequest authRequest) throws Exception {
      return loginService.login(authRequest);
    }

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World";
    }
}
