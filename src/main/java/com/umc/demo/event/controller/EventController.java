package com.umc.demo.event.controller;

import com.umc.demo.config.BaseException;
import com.umc.demo.config.BaseResponse;
import com.umc.demo.event.dto.EventCreateReq;
import com.umc.demo.event.dto.EventListRes;
import com.umc.demo.event.entity.Event;
import com.umc.demo.event.service.EventService;
import com.umc.demo.user.dto.HomeRes;
import com.umc.demo.user.entity.User;
import com.umc.demo.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/events")
public class EventController {
    private final EventService eventService;
    private final UserService userService;

    public EventController(EventService eventService, UserService userService) {
        this.userService = userService;
        this.eventService = eventService;
    }

    @ResponseBody
    @GetMapping("/{userIdx}")
    public BaseResponse<List<EventListRes>> getEventList(@PathVariable("userIdx") Long userIdx) {
        return new BaseResponse<>(eventService.getEventList(userIdx));
    }

    @ResponseBody
    @PostMapping("/{userIdx}")
    public BaseResponse<Event> createEvent(@PathVariable("userIdx") Long userIdx,  @RequestBody EventCreateReq request) {


        // Event 엔티티 생성
        Event event = Event.builder()
                .user(eventService.getUser(userIdx)) //user 메서드 호출
                .eventDate(request.getEventDate())
                .location(request.getLocation())
                .eventImg(request.getEventImg())
                .result(request.getReview())
                .build();



        return new BaseResponse<>(eventService.createEvent(event));
    }
}