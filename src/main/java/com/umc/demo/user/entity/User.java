package com.umc.demo.user.entity;

import com.umc.demo.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

@Getter
@Entity
@NoArgsConstructor
@DynamicInsert
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userIdx;

    @Column(nullable = false, name = "nickname")
    private String nickname;

    @Column(nullable = false, name = "email")
    private String email;

    @Column(nullable = false, name = "myStatus")
    private String myStatus;

    @Column(name = "userImg")
    private String userImg;

    @Column(name = "profileMessage")
    private String profileMessage;

    @Builder
    public User(Long userIdx, String nickname, String email, String myStatus, String userImg, String profileMessage) {
        this.userIdx = userIdx;
        this.nickname = nickname;
        this.email = email;
        this.myStatus = myStatus;
        this.userImg = userImg;
        this.profileMessage = profileMessage;
    }
}