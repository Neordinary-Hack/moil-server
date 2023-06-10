package com.umc.demo.review.entity;

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
@Table(name = "event_review")
@NoArgsConstructor
@DynamicInsert
public class Review extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq")
    private Long seq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eventIdx", nullable = false,insertable=false, updatable=false)
    private Event event;

    @Column(name="eventIdx")
    private Long eventIdx;
    @ManyToOne
    @JoinColumn(nullable = false, name = "userIdx")
    private User user;

    @Column(name = "review")
    private String review;

    @Builder
    public Review(Long seq, Event event, User user, String review) {
        this.seq = seq;
        this.event = event;
        this.user = user;
        this.review = review;
    }
}