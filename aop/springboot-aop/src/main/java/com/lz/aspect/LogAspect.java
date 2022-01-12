package com.lz.aspect;

import com.lz.anno.AspectLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author lihao
 */
@Aspect
@Component
@Slf4j
public class LogAspect {
    /**
     * 定义切入点，切入点为com.example.demo.aop.AopController中的所有函数
     * 通过@Pointcut注解声明频繁使用的切点表达式
     */
    //@Pointcut("execution(public * com.yzs.service.AopService.*(..)))")
    @Pointcut(value = "@annotation(com.lz.anno.AspectLog)")
    public void brokerAspect(){
    }
    
    /**
     * @description  在连接点执行之后执行的通知（返回通知和异常通知的异常）
     */
    //@After(value = "brokerAspect()")
    public void doAfterGame(JoinPoint joinPoint){

        // 获取切点方法上的注解
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        AspectLog annotation = method.getAnnotation(AspectLog.class);
        String value = annotation.value();
        String bizNo = annotation.bizNo();
        log.info("注解数据value:{}",value);
        //创建解析器
        SpelExpressionParser parser = new SpelExpressionParser();
        //获取表达式
        Expression expression = parser.parseExpression(bizNo);
        //设置解析上下文(有哪些占位符，以及每种占位符的值)
        EvaluationContext context = new StandardEvaluationContext();
        //获取参数值
        Object[] args = joinPoint.getArgs();
        //获取运行时参数的名称
        DefaultParameterNameDiscoverer discoverer = new DefaultParameterNameDiscoverer();
        String[] parameterNames = discoverer.getParameterNames(method);
        for (int i = 0; i < parameterNames.length; i++) {
            context.setVariable(parameterNames[i],args[i]);
        }
        //解析,获取替换后的结果
        String result = Objects.requireNonNull(expression.getValue(context)).toString();
        log.info("注解数据bizNo:{}",result);
    }


    @Around(value = "brokerAspect()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        log.info("方法环绕增强 ...");
        // 获取切点方法上的注解
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        Method method = methodSignature.getMethod();
        AspectLog annotation = method.getAnnotation(AspectLog.class);
        String value = annotation.value();
        String bizNo = annotation.bizNo();
        log.info("注解数据value:{}",value);
        //创建解析器
        SpelExpressionParser parser = new SpelExpressionParser();
        //获取表达式
        Expression expression = parser.parseExpression(bizNo);
        //设置解析上下文(有哪些占位符，以及每种占位符的值)
        EvaluationContext context = new StandardEvaluationContext();
        //获取参数值
        Object[] args = point.getArgs();
        //获取运行时参数的名称
        DefaultParameterNameDiscoverer discoverer = new DefaultParameterNameDiscoverer();
        String[] parameterNames = discoverer.getParameterNames(method);
        for (int i = 0; i < parameterNames.length; i++) {
            context.setVariable(parameterNames[i],args[i]);
        }
        //解析,获取替换后的结果
        String result = Objects.requireNonNull(expression.getValue(context)).toString();
        log.info("注解数据bizNo:{}",result);
        try {
            Object proceed = point.proceed();
            log.info("原本方法返回值:{}",proceed);
            return proceed;
        }catch (Exception e) {
            log.info("发生异常,处理异常");
            throw e;
        }
    }
}