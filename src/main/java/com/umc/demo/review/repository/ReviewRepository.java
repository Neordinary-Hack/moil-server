package com.umc.demo.review.repository;

import com.umc.demo.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByEventIdx(Long eventIdx);
    Review findByUserIdxAndEventIdx(Long userIdx, Long eventIdx);
}
