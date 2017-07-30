package com.sky.trading.demo.service;

import com.sky.trading.demo.model.Message;

import java.util.concurrent.CompletableFuture;

public interface DemoService {
    CompletableFuture<Message> getMessage(String message);
}
