package com.umc.demo.event.entity;

import com.umc.demo.common.BaseEntity;
import com.umc.demo.user.entity.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
@DynamicInsert
public class Event extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userIdx", nullable = false,insertable=false, updatable=false)
    private User host;

    @Column(nullable = false, name = "eventDate")
    private LocalDateTime eventDate;

    @Column(nullable = false, name = "location")
    private String location;

    @Column(name = "result")
    private String result;

    @Column(name = "eventImg")
    private String eventImg;

    @Builder
    public Event(Long eventIdx, User host, LocalDateTime eventDate, String location, String result, String eventImg) {
        this.eventIdx = eventIdx;
        this.host = host;
        this.eventDate = eventDate;
        this.location = location;
        this.result = result;
        this.eventImg = eventImg;
    }
}

