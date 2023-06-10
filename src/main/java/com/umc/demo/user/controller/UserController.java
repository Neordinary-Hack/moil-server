package com.umc.demo.user.controller;

import com.umc.demo.config.BaseException;
import com.umc.demo.config.BaseResponse;
import com.umc.demo.user.dto.GetNotiRes;
import com.umc.demo.user.dto.HomeRes;
import com.umc.demo.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UserController {
    private final UserService userService;

    @ResponseBody
    @GetMapping("/{userIdx}/home")
    public BaseResponse<HomeRes> getHome(@PathVariable("userIdx") Long userIdx) {
        try {
            return new BaseResponse<>(userService.getHome(userIdx));
        } catch (BaseException e) {
            return new BaseResponse<>(e.getStatus());
        }
    }

    @ResponseBody
    @GetMapping("/{userIdx}/notif")
    public BaseResponse<List<GetNotiRes>> getNotis(@PathVariable("userIdx") Long userIdx) {
        try {
            return new BaseResponse<>(userService.getNotis(userIdx));
        } catch (BaseException e) {
            return new BaseResponse<>(e.getStatus());
        }
    }
}