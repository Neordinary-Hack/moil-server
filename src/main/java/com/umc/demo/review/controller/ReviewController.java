package com.umc.demo.review.controller;

import com.umc.demo.config.BaseResponse;
import com.umc.demo.config.BaseResponseStatus;
import com.umc.demo.friend.service.FriendService;
import com.umc.demo.review.dto.GetReviewRes;
import com.umc.demo.review.dto.PostReviewReq;
import com.umc.demo.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @ResponseBody
    @GetMapping("")
    public BaseResponse<List<GetReviewRes>> getReview(@RequestParam Long eventIdx, @RequestParam Long userIdx) {
            return new BaseResponse<>(reviewService.getReview(eventIdx, userIdx));
    }

    @PostMapping("/{eventIdx}/{userIdx}")
    public BaseResponse<String> addReview(@PathVariable("userIdx") Long userIdx, @PathVariable("eventIdx") Long eventIdx, @RequestBody PostReviewReq postReviewReq) {
        reviewService.addReview(userIdx, eventIdx, postReviewReq);
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }
}