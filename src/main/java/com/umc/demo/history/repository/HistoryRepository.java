package com.umc.demo.history.repository;

import com.umc.demo.history.entity.History;
import com.umc.demo.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {

    List<History> findByUser(User user);
}
