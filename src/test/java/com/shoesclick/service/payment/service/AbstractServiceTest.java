package com.shoesclick.service.payment.service;

import com.shoesclick.service.payment.aspect.LoggerServiceAspect;
import com.shoesclick.service.payment.mapper.LoggerMapper;
import org.mockito.Mock;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

public abstract class AbstractServiceTest {

    @Mock
    private LogService logService;

    @Mock
    private LoggerMapper loggerMapper;

    protected AspectJProxyFactory factory;

    public <T> T setupServiceTest(T service) {
        this.factory = new AspectJProxyFactory(service);
        this.factory.addAspect(new LoggerServiceAspect(logService,loggerMapper));
        return service = this.factory.getProxy();
    }

}
