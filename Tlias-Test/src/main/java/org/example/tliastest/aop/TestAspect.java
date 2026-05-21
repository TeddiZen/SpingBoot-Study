package org.example.tliastest.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class TestAspect {

    @Pointcut("execution(* org.example.tliastest.controller.LoginController.*(..))")
    public void Loginpointcut() {
    }

    @Pointcut("execution(* org.example.tliastest.controller.EmpController.*(..))")
    public void Emppointcut() {
    }

    @Around("Loginpointcut()")
    public Object Login(ProceedingJoinPoint pjp) {
        log.info("登录前");
        Object result = null;
        try {
            result = pjp.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        log.info("登录后");
        return result;
    }

    @Around("Emppointcut()")
    public Object Emp(ProceedingJoinPoint pjp) {
        // 统计开始时间
        long startTime = System.currentTimeMillis();
        String methodName = pjp.getTarget().getClass().getSimpleName() + "." + pjp.getSignature().getName();
        log.info("员工操作前: {}", methodName);
        Object result = null;
        try {
            result = pjp.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        // 统计耗时间
        long endTime = System.currentTimeMillis();
        long costTime = endTime - startTime;
        log.info("员工操作耗时: {}ms", costTime);
        log.info("员工操作后: {}", methodName);
        return result;
    }
}
