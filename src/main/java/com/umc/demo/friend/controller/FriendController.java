package com.umc.demo.friend.controller;

import com.umc.demo.friend.service.FriendService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/friends")
public class FriendController {
    private FriendService friendService;

    public FriendController(FriendService friendService) {

        this.friendService = friendService;
    }
}
