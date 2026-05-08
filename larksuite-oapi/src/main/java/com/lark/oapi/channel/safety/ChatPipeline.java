package com.lark.oapi.channel.safety;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

class ChatPipeline {
    private final ConcurrentHashMap<String, CompletableFuture<Void>> tails = new ConcurrentHashMap<String, CompletableFuture<Void>>();

    void run(String scope, Runnable task) {
        if (scope == null || scope.isEmpty()) {
            task.run();
            return;
        }
        tails.compute(scope, (key, previous) -> {
            CompletableFuture<Void> base = previous == null ? CompletableFuture.completedFuture(null) : previous;
            CompletableFuture<Void> next = base.handle((ignored, error) -> null).thenRun(task);
            return next.whenComplete((ignored, error) -> {
                if (tails.get(key) == next) {
                    tails.remove(key);
                }
            });
        }).join();
    }

    void flushAll() {
        for (Map.Entry<String, CompletableFuture<Void>> entry : tails.entrySet()) {
            entry.getValue().handle((ignored, error) -> null).join();
        }
    }

    void clear() {
        tails.clear();
    }
}
