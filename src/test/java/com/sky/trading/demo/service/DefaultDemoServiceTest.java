package com.sky.trading.demo.service;

import com.sky.trading.demo.model.Message;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultDemoServiceTest {

    private DefaultDemoService demoService;

    @Before
    public void setUp() throws Exception {
        demoService = new DefaultDemoService();
    }

    @Test
    public void getMessage() throws Exception {
        assertThat(getOrThrow(demoService.getMessage("test")))
                .isEqualToComparingFieldByField(new Message("test"));
    }

    private static <T> T getOrThrow(Future<T> future) throws Exception {
        try {
            return future.get(2, TimeUnit.SECONDS);
        }
        catch (ExecutionException e) {
            Throwable cause = e.getCause();
            throw cause instanceof Exception ? (Exception)cause : new RuntimeException(cause);
        }
    }
}