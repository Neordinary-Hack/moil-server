package com.umc.demo.event.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EventGetRes {

    private Long eventIdx;
    private Long userIdx;
    private LocalDateTime eventDate;
    private String result;
    private String eventImg;
    private boolean isReviewed;

}