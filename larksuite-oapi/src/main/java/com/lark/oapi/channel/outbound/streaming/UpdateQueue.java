package com.lark.oapi.channel.outbound.streaming;

public class UpdateQueue {
    public interface QueueTask {
        void run() throws Exception;
    }

    public synchronized void enqueue(QueueTask task) throws Exception {
        task.run();
    }

    public void drain() {
    }
}
