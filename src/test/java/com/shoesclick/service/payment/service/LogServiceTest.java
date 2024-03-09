package com.shoesclick.service.payment.service;

import com.shoesclick.service.payment.entity.Log;
import com.shoesclick.service.payment.repository.LogRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class LogServiceTest {

    @Mock
    private LogRepository logRepository;

    @InjectMocks
    private LogService logService;


    @Test
    void shouldSaveLogSuccess() {
        var log = new Log();
        logService.save(log);
        verify(logRepository, times(1)).save(any(Log.class));
    }

}
