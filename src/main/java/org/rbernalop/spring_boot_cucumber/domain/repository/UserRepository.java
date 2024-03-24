package org.rbernalop.spring_boot_cucumber.domain.repository;

import org.rbernalop.spring_boot_cucumber.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
