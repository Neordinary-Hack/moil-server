package com.umc.demo.history.entity;

import com.umc.demo.common.BaseEntity;
import com.umc.demo.event.entity.Event;
import com.umc.demo.user.entity.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

@Getter
@Entity
@Table(name = "notif_history")
@NoArgsConstructor
@DynamicInsert
public class History extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notif_idx")
    private Long notifIdx;

    @ManyToOne
    @JoinColumn(nullable = false, name = "user_idx")
    private User user;

    @ManyToOne
    @JoinColumn(nullable = false, name = "event_idx")
    private Event event;

    @Column(nullable = false, name = "title")
    private String title;

    @Column(name = "message")
    private String message;

    @Builder
    public History(Long notifIdx, User user, Event event, String title, String message) {
        this.notifIdx = notifIdx;
        this.user = user;
        this.event = event;
        this.title = title;
        this.message = message;
    }
}