package com.horvat.basicwebshop.repository;

import com.horvat.basicwebshop.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
