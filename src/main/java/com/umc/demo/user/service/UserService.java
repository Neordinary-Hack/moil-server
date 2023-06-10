package com.umc.demo.user.service;

import com.umc.demo.config.BaseException;
import com.umc.demo.config.BaseResponseStatus;
import com.umc.demo.user.dto.HomeRes;
import com.umc.demo.user.entity.User;
import com.umc.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public HomeRes getHome(Long userIdx) throws BaseException{
        try {
            User user = userRepository.findByUserIdx(userIdx);
            return new HomeRes(user.getMyStatus());
        } catch (Exception e) {
            throw new BaseException(BaseResponseStatus.DATABASE_ERROR);
        }
    }
}
