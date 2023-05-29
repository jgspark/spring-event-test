package com.example.springeventtest.domain.event;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long mailId;

    private Long pushId;

    private Long count;

    private LocalDateTime createdAt;

    @PrePersist
    void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.count = 0L;
    }

    public static History of(Long mailId, Long pushId) {
        return new History(mailId, pushId);
    }

    private History(Long mailId, Long pushId) {
        this.mailId = mailId;
        this.pushId = pushId;
    }

    void update() {
        this.createdAt = LocalDateTime.now();
        this.count += 1L;
    }
}
