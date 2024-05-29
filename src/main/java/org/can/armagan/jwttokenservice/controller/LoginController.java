package org.can.armagan.jwttokenservice.controller;

import lombok.RequiredArgsConstructor;
import org.can.armagan.jwttokenservice.model.AuthRequest;
import org.can.armagan.jwttokenservice.model.UserRoles;
import org.can.armagan.jwttokenservice.service.LoginService;
import org.can.armagan.jwttokenservice.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;
    private final UserService userService;

    @PostMapping("/login")
    public String creteToken(@RequestBody AuthRequest authRequest) {
      return loginService.login(authRequest);
    }

    @PostMapping("/adduser")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String insertUser(@RequestBody AuthRequest authRequest) {
        userService.createUser(authRequest.getUsername(), authRequest.getPassword());
        return "The user has been successfully registered.";
    }
    @PostMapping("/addrole")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addRole(@RequestBody UserRoles userRoles) {
        userService.addRoleToUser(userRoles.getUserId(), userRoles.getRoleId());
        return "The role has been successfully added.";
    }
    @DeleteMapping("/deleteuser/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "The user has been successfully deleted.";
    }
    @GetMapping("/helloGuest")
    public String helloGuest() {
        return "Hello Guest";
    }
    @GetMapping("/helloEditor")
    @PreAuthorize("hasRole('ROLE_EDITOR')")
    public String helloEditor() {
        return "Hello Editör";
    }
    @GetMapping("/helloAdmin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String helloAdmin() {
        return "Hello Admin";
    }


}
