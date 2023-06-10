package com.umc.demo.friend.controller;

import com.umc.demo.config.BaseResponse;
import com.umc.demo.friend.dto.GetFriendRes;
import com.umc.demo.friend.service.FriendService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/friends")
public class FriendController {
    private final FriendService friendService;

    @ResponseBody
    @GetMapping("/{userIdx}")
    public BaseResponse<List<GetFriendRes>> getFriend(@PathVariable("userIdx") Long userIdx) {
        return new BaseResponse<>(friendService.getFriend(userIdx));
    }
}
