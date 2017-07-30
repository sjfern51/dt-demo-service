package com.sky.trading.demo.service;

import com.sky.trading.demo.model.Message;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class DefaultDemoService implements DemoService {
    @Override
    public CompletableFuture<Message> getMessage(String message) {
        return CompletableFuture.supplyAsync(() -> new Message(message));
    }
}
