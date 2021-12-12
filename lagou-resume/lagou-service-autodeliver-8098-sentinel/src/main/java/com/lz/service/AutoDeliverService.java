package com.lz.service;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author lihao
 * @date 2021-11-24 20:43
 */
@Service
public class AutoDeliverService {


    @SneakyThrows
    public Integer deliver() {
        TimeUnit.SECONDS.sleep(10);
        return 10;
    }
}
