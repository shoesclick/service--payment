package com.shoesclick.service.payment.aspect;


import com.shoesclick.service.payment.entity.Log;
import com.shoesclick.service.payment.enums.TypeLog;
import com.shoesclick.service.payment.mapper.LoggerMapper;
import com.shoesclick.service.payment.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class LoggerServiceAspect {

    private final LogService logService;

    private final LoggerMapper loggerMapper;

    public LoggerServiceAspect(LogService logService, LoggerMapper loggerMapper) {
        this.logService = logService;
        this.loggerMapper = loggerMapper;
    }

    @Around("@annotation(InjectLogger)")
    public void logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        Log log = null;
        try {
            joinPoint.proceed();
            log = loggerMapper.map(
                    getMethodSignature(joinPoint).getName(),
                    "SUCESSO",
                    "EXECUTADO COM SUCESSO",
                    TypeLog.SUCCESS);
        } catch (Exception exception) {
            log = loggerMapper.map(
                    getMethodSignature(joinPoint).getName(),
                    "ERRO",
                    exception.getMessage(),
                    TypeLog.ERROR);
        } finally {
            logService.save(log);
        }
    }

    private Method getMethodSignature(ProceedingJoinPoint joinPoint) {
        return MethodSignature.class.cast(joinPoint.getSignature()).getMethod();
    }
}
