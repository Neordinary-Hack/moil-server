package com.umc.demo.friend.entity;

import com.umc.demo.common.BaseEntity;
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

    @ManyToOne
    @JoinColumn(nullable = false, name = "user_idx")
    private User userIdx;

    @JoinColumn(nullable = false, name = "")
    private Long friendIdx;

    @Column(name = "friendTerm")
    @ColumnDefault("30")
    private int friendTerm;

    @Column(name = "relationStatus")
    @ColumnDefault("0")
    private int relationStatus;
}
