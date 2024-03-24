package org.rbernalop.spring_boot_cucumber.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class Notification {
    @Id
    private String id;

    private String content;

    private LocalDateTime dateToSend;

    @ManyToOne
    private User user;

}
