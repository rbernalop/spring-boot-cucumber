package org.rbernalop.spring_boot_cucumber.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.rbernalop.spring_boot_cucumber.domain.exception.InvalidDataException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "user_app")
public class User {
    @Id
    private UUID id;
    private String username;
    private int age;
    private String email;
    private boolean hasActiveNotifications;

    @OneToMany
    private List<Notification> notifications;

    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    public User(String id, String username, int age, String email, boolean hasActiveNotifications) {
        this.id = UUID.fromString(id);

        if (username == null || username.isBlank()) {
            throw new InvalidDataException("Invalid username");
        }
        this.username = username;

        if (age < 18) {
            throw new InvalidDataException("User cannot be underage");
        }
        this.age = age;

        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            throw new InvalidDataException("Invalid email");
        }
        this.email = email;
        this.hasActiveNotifications = hasActiveNotifications;
        this.notifications = new ArrayList<>();
    }
}
