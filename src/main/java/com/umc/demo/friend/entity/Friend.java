package com.umc.demo.friend.entity;

import com.umc.demo.common.BaseEntity;
import com.umc.demo.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

@Getter
@Entity
@NoArgsConstructor
@DynamicInsert
public class Friend extends BaseEntity {

    @Id
    @GeneratedValue
    private Long seq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userIdx", nullable = false,insertable=false, updatable=false)
    private User user;

    @Column(name="userIdx")
    private Long userIdx;

    @JoinColumn(nullable = false, name = "")
    private Long friendIdx;

    @Column(name = "friendTerm")
    @ColumnDefault("30")
    private int friendTerm;

    @Column(name = "relationStatus")
    @ColumnDefault("0")
    private int relationStatus;
}
