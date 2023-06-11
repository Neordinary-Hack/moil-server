package com.umc.demo.review.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.umc.demo.config.BaseResponse;
import com.umc.demo.config.BaseResponseStatus;
import com.umc.demo.review.dto.GetReviewRes;
import com.umc.demo.review.dto.PatchReviewReq;
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
    public BaseResponse<String> addReview(@PathVariable("userIdx") Long eventIdx, @PathVariable("eventIdx") Long userIdx, @RequestBody PostReviewReq postReviewReq) throws JsonProcessingException {
        reviewService.addReview(eventIdx, userIdx, postReviewReq);
        return new BaseResponse<>(reviewService.addReview(eventIdx, userIdx, postReviewReq));
    }

    @PatchMapping("/{eventIdx}/{userIdx}")
    public BaseResponse<String> editReview(@PathVariable("eventIdx") Long eventIdx, @PathVariable("userIdx") Long userIdx, @RequestBody PatchReviewReq patchReviewReq) {
        reviewService.editReview(eventIdx, userIdx, patchReviewReq);
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }
}