package com.umc.demo.history.controller;

import com.umc.demo.history.service.HistoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/histories")
public class HistoryController {
    private HistoryService historyService;

    public HistoryController(HistoryService historyService) {

        this.historyService = historyService;
    }
}