package com.lz.controller;

import com.lz.service.AutoDeliverService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author lihao
 * @date 2021-11-07 20:37
 */
@RestController
@RequestMapping("/auto-deliver")
@SuppressWarnings("all")
public class controller {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AutoDeliverService autoDeliverService;

    /*@GetMapping("/check-state/{userId}")
    public Integer findResumeOpenState(@PathVariable Long userId) {
        //调用远程服务
        String url = "http://localhost:8080/resume/open-state/"+userId;
        Integer status = restTemplate.getForObject(url, Integer.class);
        return status;
    }*/

    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * Eureka改造
     * @param userId
     * @return
     */
    /*@GetMapping("/check-state/{userId}")
    public Integer findResumeOpenState(@PathVariable Long userId) {
        //1,从Eureka Server中获取服务的实例信息
        List<ServiceInstance> instances = discoveryClient.getInstances("LAGOU-SERVICE-RESUME");
        //2,如果返回多了,选择一个使用(负载均衡)
        ServiceInstance serviceInstance = instances.get(0);
        //3,从元数据中获取host port
        String host = serviceInstance.getHost();
        int port = serviceInstance.getPort();
        String url = "http://"+host+":"+port+"/resume/open-state/"+userId;
        Integer status = restTemplate.getForObject(url, Integer.class);
        return status;
    }*/


    /**
     * 改造 -> Ribbon 负载均衡
     * @param userId
     * @return
     */
    @GetMapping("/check-state/{userId}")
    public Integer findResumeOpenState(@PathVariable Long userId) {
        //不需要自己获取服务实例然后选择一个去访问,只需要指定服务名
        String url = "http://LAGOU-SERVICE-RESUME/resume/open-state/"+userId;
        Integer status = restTemplate.getForObject(url, Integer.class);
        return status;
    }

    /**
     * 提供者模拟处理超时,调用方法添加Hystrix
     * 1) 服务提供者处理超时,熔断后返回错误信息
     * 2) 有可能服务提供者出现异常直接抛出异常信息
     * 以上信息,都会返回到消费者这里,很多时候消费者服务不希望收到异常/错误信息再抛到上游
     * 比如: 用户微服务 -> 注册微服务 -> 优惠券微服务
     *                  1,登记注册 2,分发优惠券(并不是核心步骤),这里如果调用优惠券微服务返回了异常或者错误信息,这些信息如果抛给用户很不友好,
     *                              此时可以返回一个兜底数据(预设的默认值即:服务的降级)
     * {@code @HystrixCommand 扫描注解,进行切面}
     * @return
     */
    @SneakyThrows
    @HystrixCommand(
            //熔断细节属性配置 每一个属性都是一个HystrixProperty
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
            }
    )
    @GetMapping("/check-state-timeout/{userId}")
    public Integer findResumeOpenStateTimeOut(@PathVariable Long userId) {
        //该服务调用别的服务超时和该服务中普通方法超时效果是一样的,本质上是该服务响应时间如果超过上面设置的2000毫秒,就会抛出熔断异常.
        // 本质是作在方法上,该方法超时,触发熔断
        TimeUnit.SECONDS.sleep(10);
        //不需要自己获取服务实例然后选择一个去访问,只需要指定服务名
        String url = "http://LAGOU-SERVICE-RESUME/resume/open-state/"+userId;
        Integer status = restTemplate.getForObject(url, Integer.class);
        return status;
    }

    @HystrixCommand(
            //熔断细节属性配置 每一个属性都是一个HystrixProperty
            commandProperties = {
                    //该配置可以作用于方法,也可以在配置文件中配置,作用于全局,优先级方法上大于全局
                    @HystrixProperty(name =
                            "execution.isolation.thread.timeoutInMilliseconds",value = "2000"),
                    //高级配置,制定工作细节,下面定义规则解释: 8秒内最小请求达到2个,且错误比例为50%,则进行熔断降级,这时候会每隔几秒放行请求,
                    //如果熔断3秒后有请求可以成功,则自我恢复,取消熔断. -- 个人理解,该配置是针对该方法,与扇出服务无关.因为切面也是切的该方法.
                    //统计时间窗口定义
                    @HystrixProperty(name =
                            "metrics.rollingStats.timeInMilliseconds",value = "8000"),
                    //统计时间窗口内最小请求数
                    @HystrixProperty(name =
                            "circuitBreaker.requestVolumeThreshold",value = "2"),
                    //统计时间窗口内错误数量百分比阈值
                    @HystrixProperty(name =
                            "circuitBreaker.errorThresholdPercentage",value = "50"),
                    //自我修复时的活动窗口长度,可以理解为熔断后的休眠时间,休眠时为熔断状态
                    @HystrixProperty(name =
                            "circuitBreaker.sleepWindowInMilliseconds",value = "3000")
            },
            //回退方法
            fallbackMethod = "fallBack",
            //线程池标识,保持唯一,不唯一就会公用
            threadPoolKey = "findResumeOpenStateTimeOutFallback",
            //线程池细节属性配置
            threadPoolProperties = {
                    //线程数
                @HystrixProperty(name = "coreSize",value = "5"),
                    //最大等待队列
                @HystrixProperty(name = "maxQueueSize",value = "20")
            }
    )
    @GetMapping("/check-state-timeout-fallback/{userId}")
    public Integer findResumeOpenStateTimeOutFallback(@PathVariable Long userId) {
        //不需要自己获取服务实例然后选择一个去访问,只需要指定服务名
        String url = "http://LAGOU-SERVICE-RESUME/resume/open-state/"+userId;
        Integer status = restTemplate.getForObject(url, Integer.class);
        return status;
    }

    /**
     * 定义回退方法: 返回预设默认值
     * 注意: 该方法形参和返回值与原始方法保持一致
     */
    public Integer fallBack(Long userId) {
        return -1;//兜底数据
    }


    /**
     * hystrix:本质是对方法的代理,如果方法出现预设的情况,比如超时等,返回兜底数据作为服务的降级.
     * 核心: 该特性作用于方法,对需要熔断的方法进行设置熔断策略
     */
    @GetMapping("/check-state-timeout-fallback-onmethod/{userId}")
    public Integer findResumeOpenStateTimeOutFallbackOnMethod(@PathVariable Long userId) {
        return autoDeliverService.deliver();
    }



}
