package org.can.armagan.jwttokenservice.repository;

import org.can.armagan.jwttokenservice.model.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRolesRepository extends JpaRepository<UserRoles, Integer> {
}

