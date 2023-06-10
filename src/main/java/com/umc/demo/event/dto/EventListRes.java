package com.umc.demo.event.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EventListRes {
    private Long event_idx;
    private Long host_idx;
    private int event_date_year;
    private String event_date_month;
    private int event_date_day;
    private String location;
    private String event_img;
}
