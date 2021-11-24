package com.lz.controller;


import com.lz.service.RResumeService;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author lihao
 * @since 2021-11-07
 */
@RestController
@RequestMapping("/resume")
public class RResumeController {

    private final RResumeService resumeService;

    public RResumeController(RResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @SneakyThrows
    @GetMapping("/open-state/{userId}")
    public Integer findDefaultResumeState(@PathVariable Long userId) {
        TimeUnit.SECONDS.sleep(10);
        return resumeService.findDefaultResumeStateByUserId(userId);
    }

}

