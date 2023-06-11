package com.umc.demo.review.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.umc.demo.event.entity.Event;
import com.umc.demo.event.repository.EventRepository;
import com.umc.demo.review.dto.GetReviewRes;

import com.umc.demo.review.dto.PatchReviewReq;

import com.umc.demo.review.dto.PostReviewReq;
import com.umc.demo.review.entity.Review;
import com.umc.demo.review.repository.ReviewRepository;
import com.umc.demo.user.entity.User;
import com.umc.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    public List<GetReviewRes> getReview(Long eventIdx, Long userIdx) {
        User user = userRepository.findByUserIdx(userIdx);
        return reviewRepository.findByEventIdx(eventIdx).stream()
                .map(review ->
                        new GetReviewRes(review.getSeq(),
                                user.getNickname(),
                                review.getReview())).collect(Collectors.toList());
    }

    public String addReview(Long eventIdx, Long userIdx, PostReviewReq postReviewReq) throws JsonProcessingException {
        Review review = reviewRepository.findByUserIdxAndEventIdx(userIdx, eventIdx);
        review.setReview(postReviewReq.getReview());
        reviewRepository.save(review);

        String requestBody ="";

        List<Review> reviews = reviewRepository.findByEventIdx(eventIdx);
        for (Review r : reviews) {
            String str = r.getReview();
            requestBody += str;
            requestBody += ", ";
        }

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        final String apiUrl = "http://localhost:8008/OpenAi/chat/create";

        ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, String.class);
        String responseBody = responseEntity.getBody();
        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode jsonNode = objectMapper.readTree(responseBody);

        String fieldValue = jsonNode.path("choices").get(0).path("message").path("content").asText();

            Event event = eventRepository.findByEventIdx(eventIdx);
            event.setResult(responseEntity.getBody());

        return fieldValue;
    }

    public void editReview(Long eventIdx, Long userIdx, PatchReviewReq patchReviewReq) {
        Review review = reviewRepository.findByUserIdxAndEventIdx(userIdx, eventIdx);
        review.setReview(patchReviewReq.getReview());
        reviewRepository.save(review);
    }
}
