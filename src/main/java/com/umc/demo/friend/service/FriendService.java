package com.umc.demo.friend.service;

import com.umc.demo.friend.dto.GetFriendRes;
import com.umc.demo.friend.repository.FriendRepository;
import com.umc.demo.user.entity.User;
import com.umc.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FriendService {
    private final FriendRepository friendRepository;
    private final UserRepository userRepository;

    public List<GetFriendRes> getFriend(Long userIdx) {
        User user = userRepository.findByUserIdx(userIdx);
        return friendRepository.findByUserIdx(userIdx).stream()
                .map(friend ->
                        new GetFriendRes(user.getNickname(),
                                friend.getRelationStatus())).collect(Collectors.toList());
    }
}
