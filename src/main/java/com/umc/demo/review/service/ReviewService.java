package com.umc.demo.review.service;

import com.umc.demo.review.dto.GetReviewRes;
import com.umc.demo.review.repository.ReviewRepository;
import com.umc.demo.user.entity.User;
import com.umc.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;

    public List<GetReviewRes> getReview(Long eventIdx, Long userIdx) {
        User user = userRepository.findByUserIdx(userIdx);
        return reviewRepository.findByEventIdx(eventIdx).stream()
                .map(review ->
                        new GetReviewRes(review.getSeq(),
                                user.getNickname(),
                                review.getReview())).collect(Collectors.toList());
    }
}
