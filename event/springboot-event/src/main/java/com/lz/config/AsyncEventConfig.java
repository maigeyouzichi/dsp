package com.lz.config;

import com.alibaba.fastjson.JSON;
import java.lang.reflect.Method;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;

/**
 * 异步事件配置
 * @author lihao on 2023/4/16
 */
@Configuration
@Slf4j
public class AsyncEventConfig implements AsyncConfigurer {

//    @Override
//    public Executor getAsyncExecutor() {
//        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
//        taskExecutor.setCorePoolSize(5);
//        taskExecutor.setMaxPoolSize(10);
//        taskExecutor.setQueueCapacity(1000);
//        taskExecutor.setThreadNamePrefix("event-thread-");
//        taskExecutor.initialize();
//        return taskExecutor;
//    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new AsyncEventExceptionHandler();
    }

    static class AsyncEventExceptionHandler implements AsyncUncaughtExceptionHandler {
        @Override
        public void handleUncaughtException(Throwable ex, Method method, Object... params) {
            for (Object param : params) {
                log.error("asyncEventExceptionHandler error, params: {}", JSON.toJSONString(param));
            }
            log.error("asyncEventExceptionHandler error, method: {}", method);
            log.error("asyncEventExceptionHandler error", ex);
        }
    }
}
