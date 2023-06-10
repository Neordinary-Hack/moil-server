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
public class EventCreateReq {

    private String eventImg;
    private String review;
    private LocalDateTime eventDate;
    private String location;
    private String friends;
}
