package com.sky.trading.demo.provider.session.trading;

import com.sky.trading.demo.model.Session;
import com.sky.trading.demo.provider.session.SessionProvider;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class TradingSessionProvider implements SessionProvider {
    @Override
    public CompletableFuture<Session> fetch(String sessionId) {
        return CompletableFuture.completedFuture(new Session());
    }
}
