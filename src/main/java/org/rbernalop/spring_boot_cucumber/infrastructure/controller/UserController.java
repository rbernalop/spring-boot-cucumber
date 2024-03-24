package org.rbernalop.spring_boot_cucumber.infrastructure.controller;

import lombok.RequiredArgsConstructor;
import org.rbernalop.spring_boot_cucumber.application.dto.CreateUserDto;
import org.rbernalop.spring_boot_cucumber.application.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody CreateUserDto createUserDto) {
        userService.createUser(createUserDto.getId(), createUserDto.getUsername(), createUserDto.getAge(),
            createUserDto.getEmail(), createUserDto.isHasActiveNotifications());
    }
}
