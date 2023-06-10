package com.umc.demo.history.service;

import com.umc.demo.history.repository.HistoryRepository;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {
    private HistoryRepository historyRepository;

    public HistoryService(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }
}
