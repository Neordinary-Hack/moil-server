package com.umc.demo.event.service;

import com.umc.demo.config.BaseException;
import com.umc.demo.config.BaseResponseStatus;
import com.umc.demo.event.dto.EventListRes;
import com.umc.demo.event.entity.Event;
import com.umc.demo.event.repository.EventRepository;
import com.umc.demo.user.dto.HomeRes;
import com.umc.demo.user.entity.User;
import com.umc.demo.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {
    private final EventRepository eventRepository;

    private final UserRepository userRepository;

    public EventService(EventRepository eventRepository, UserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }


    public List<EventListRes> getEventList(Long userIdx) {

        List<Event> events = eventRepository.findByUserIdx(userIdx);

        return events.stream()
                .map(event -> new EventListRes(
                        event.getEventIdx(),
                        event.getUser().getUserIdx(),
                        event.getEventDate().getYear(),
                        event.getEventDate().getMonth().toString(),
                        event.getEventDate().getDayOfMonth(),
                        event.getLocation(),
                        event.getEventImg()
                ))
                .collect(Collectors.toList());
    }

    @Transactional
    public Event createEvent(Event event) {
        // 이벤트 정보 가져오기

        return eventRepository.save(event); // Event 엔티티를 데이터베이스에 저장하고 반환
    }

    public User getUser(Long userIdx){
        return userRepository.findByUserIdx(userIdx);
    }
}
