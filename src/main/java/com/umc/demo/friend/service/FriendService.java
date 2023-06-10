package com.umc.demo.friend.service;

import com.umc.demo.friend.repository.FriendRepository;
import org.springframework.stereotype.Service;

@Service
public class FriendService {
    private FriendRepository friendRepository;

    public FriendService(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
    }
}
