package com.umc.demo.event.repository;

import com.umc.demo.event.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByUserIdx(Long userIdx);
    Event findByEventIdx(Long eventIdx);

    Event save(Event event);

    Event findByUserIdxAndEventIdx(Long userIdx, Long EventIdx);

}

