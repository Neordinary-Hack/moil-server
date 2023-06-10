package com.umc.demo.review.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetReviewRes {
    private Long reviewIdx;
    private String nickname;
    private String review;
}
