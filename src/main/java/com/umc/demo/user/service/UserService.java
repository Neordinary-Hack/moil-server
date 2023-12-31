package com.umc.demo.user.service;

import com.umc.demo.config.BaseException;
import com.umc.demo.config.BaseResponseStatus;
import com.umc.demo.history.repository.HistoryRepository;
import com.umc.demo.user.dto.GetNotiRes;
import com.umc.demo.user.dto.HomeRes;
import com.umc.demo.user.entity.User;
import com.umc.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final HistoryRepository historyRepository;

    public HomeRes getHome(Long userIdx) throws BaseException {
        try {
            User user = userRepository.findByUserIdx(userIdx);
            return new HomeRes(user.getMyStatus());
        } catch (Exception e) {
            throw new BaseException(BaseResponseStatus.DATABASE_ERROR);
        }
    }

    public List<GetNotiRes> getNotis(Long userIdx) throws BaseException {
        try {
            User user = userRepository.findByUserIdx(userIdx);
            return historyRepository.findByUser(user).stream()
                    .map(history -> new GetNotiRes(history.getNotifIdx(),
                            history.getTitle(),
                            history.getMessage())).collect(Collectors.toList());
        } catch (Exception e) {
            throw new BaseException(BaseResponseStatus.DATABASE_ERROR);
        }
    }
}
