package com.sky.trading.demo.provider.session;

import com.sky.trading.demo.model.Session;

import java.util.concurrent.CompletableFuture;

public interface SessionProvider {
    CompletableFuture<Session> fetch(String sessionId);
}
