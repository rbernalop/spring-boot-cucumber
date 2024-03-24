package org.rbernalop.spring_boot_cucumber.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.rbernalop.spring_boot_cucumber.domain.User;
import org.rbernalop.spring_boot_cucumber.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void createUser(String id, String username, int age, String email, boolean hasActiveNotifications) {
        User user = new User(id, username, age, email, hasActiveNotifications);
        userRepository.save(user);
    }
}
