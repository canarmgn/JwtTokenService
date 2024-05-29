package org.can.armagan.jwttokenservice.service;

import lombok.RequiredArgsConstructor;
import org.can.armagan.jwttokenservice.model.User;
import org.can.armagan.jwttokenservice.model.UserRoles;
import org.can.armagan.jwttokenservice.repository.UserRepository;
import org.can.armagan.jwttokenservice.repository.UserRolesRepository;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserRolesRepository userRolesRepository;

    public void createUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        userRepository.save(user);
    }

    public void addRoleToUser(long userId, long roleId) {
        UserRoles userRoles = new UserRoles();
        userRoles.setUserId(userId);
        userRoles.setRoleId(roleId);
        userRolesRepository.save(userRoles);

    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
