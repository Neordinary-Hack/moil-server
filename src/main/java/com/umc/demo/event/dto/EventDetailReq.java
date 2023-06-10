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
public class EventDetailReq {

    private boolean isSuccess;
    private int code;
    private String message;
    private long eventIdx;
    private long hostIdx;
    private LocalDateTime eventDate;
    private String result;
    private String eventImg;
    private boolean isReviewed;

}
