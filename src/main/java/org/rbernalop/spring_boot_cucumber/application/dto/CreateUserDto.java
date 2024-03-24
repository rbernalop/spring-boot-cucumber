package org.rbernalop.spring_boot_cucumber.application.dto;

import lombok.Data;

@Data
public class CreateUserDto {
    private String id;
    private String username;
    private int age;
    private String email;
    private boolean hasActiveNotifications;
}
