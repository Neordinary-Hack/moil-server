package com.umc.demo.review.entity;

import com.umc.demo.common.BaseEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

// 테이블 이름 어노테이션으로 설정 필요
@Getter
@Entity
@NoArgsConstructor
@DynamicInsert
public class Review extends BaseEntity {
}
