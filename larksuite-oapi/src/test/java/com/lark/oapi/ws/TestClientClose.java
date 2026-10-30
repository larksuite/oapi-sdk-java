package com.lark.oapi.ws;

import org.junit.Test;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;

public class TestClientClose {
    private void startHeartbeat(Client client) throws Exception {
        java.lang.reflect.Method method = Client.class.getDeclaredMethod("startPingLoop");
        method.setAccessible(true);
        method.invoke(client);
    }

    private CountDownLatch stopSignal(Client client) throws Exception {
        java.lang.reflect.Field field = Client.class.getDeclaredField("pingStopSignal");
        field.setAccessible(true);
        return (CountDownLatch) field.get(client);
    }

    @Test(timeout = 8000)
    public void closeWakesHeartbeatDuringLongInterval() throws Exception {
        Client client = client();
        try {
            startHeartbeat(client);
            // Let the initial two-second delay elapse and enter the 120-second interval.
            Thread.sleep(2200);
            client.close();
            client.executor.shutdown();
            assertTrue("Heartbeat should wake without interrupting the executor",
                    client.executor.awaitTermination(1, TimeUnit.SECONDS));
        } finally {
            client.executor.shutdownNow();
        }
    }

    @Test(timeout = 5000)
    public void restartDoesNotReviveOldHeartbeatOrClearNewSignal() throws Exception {
        Client client = client();
        try {
            startHeartbeat(client);
            CountDownLatch oldSignal = stopSignal(client);
            client.close();
            client.userClosed = false; // Exercise heartbeat restart without network access.
            startHeartbeat(client);
            CountDownLatch newSignal = stopSignal(client);
            assertNotSame(oldSignal, newSignal);
            assertEquals(0, oldSignal.getCount());
            assertEquals(1, newSignal.getCount());
            startHeartbeat(client);
            assertSame(newSignal, stopSignal(client));
            client.close(true, 1000);
            assertEquals(0, newSignal.getCount());
            assertTrue(client.executor.isTerminated());
        } finally {
            client.executor.shutdownNow();
        }
    }

    @Test(timeout = 5000)
    public void stoppingHeartbeatDoesNotInterruptBusinessTask() throws Exception {
        Client client = client();
        CountDownLatch started = new CountDownLatch(1);
        CountDownLatch release = new CountDownLatch(1);
        try {
            Future<Boolean> business = client.executor.submit(() -> {
                started.countDown();
                release.await();
                return true;
            });
            assertTrue(started.await(1, TimeUnit.SECONDS));
            startHeartbeat(client);
            client.close();
            assertFalse(business.isDone());
            release.countDown();
            client.close(true, 1000);
            assertTrue(business.get(1, TimeUnit.SECONDS));
            assertTrue(client.executor.isTerminated());
        } finally {
            release.countDown();
            client.executor.shutdownNow();
        }
    }

    private Client client() {
        return new Client.Builder("app_id", "app_secret").autoReconnect(true).build();
    }

    @Test
    public void defaultClosePreservesExecutorAndStopsReconnect() throws Exception {
        Client client = client();
        try {
            client.close();
            assertTrue(client.userClosed);
            assertFalse(client.shouldReconnect());
            assertFalse(client.executor.isShutdown());
            assertEquals("usable", client.executor.submit(() -> "usable").get(2, TimeUnit.SECONDS));
        } finally {
            client.executor.shutdownNow();
        }
    }

    @Test
    public void falseShutdownPreservesExecutor() {
        Client client = client();
        try {
            client.close(false);
            client.close(false, 0);
            assertTrue(client.userClosed);
            assertFalse(client.executor.isShutdown());
        } finally {
            client.executor.shutdownNow();
        }
    }

    @Test
    public void gracefulShutdownLetsExistingTaskFinish() throws Exception {
        Client client = client();
        CountDownLatch started = new CountDownLatch(1);
        CountDownLatch release = new CountDownLatch(1);
        Future<Boolean> task = client.executor.submit(() -> {
            started.countDown();
            release.await();
            return true;
        });
        Thread releaser = new Thread(() -> {
            while (!client.executor.isShutdown()) Thread.yield();
            release.countDown();
        });
        releaser.setDaemon(true);
        try {
            assertTrue(started.await(2, TimeUnit.SECONDS));
            releaser.start();
            client.close(true, 2000);
            assertTrue(task.get(2, TimeUnit.SECONDS));
            assertTrue(client.executor.isTerminated());
        } finally {
            release.countDown();
            client.executor.shutdownNow();
            releaser.join(2000);
        }
    }

    @Test
    public void zeroTimeoutInterruptsUnfinishedTask() throws Exception {
        Client client = client();
        CountDownLatch started = new CountDownLatch(1);
        CountDownLatch interrupted = new CountDownLatch(1);
        client.executor.execute(() -> {
            started.countDown();
            try {
                new CountDownLatch(1).await();
            } catch (InterruptedException expected) {
                interrupted.countDown();
            }
        });
        try {
            assertTrue(started.await(2, TimeUnit.SECONDS));
            client.close(true, 0);
            assertTrue(interrupted.await(2, TimeUnit.SECONDS));
            assertTrue(client.executor.awaitTermination(2, TimeUnit.SECONDS));
        } finally {
            client.executor.shutdownNow();
        }
    }

    @Test
    public void interruptionForcesShutdownAndRestoresFlag() throws Exception {
        Client client = client();
        CountDownLatch started = new CountDownLatch(1);
        client.executor.execute(() -> {
            started.countDown();
            try { new CountDownLatch(1).await(); }
            catch (InterruptedException expected) { Thread.currentThread().interrupt(); }
        });
        try {
            assertTrue(started.await(2, TimeUnit.SECONDS));
            Thread.currentThread().interrupt();
            client.close(true, 2000);
            assertTrue(Thread.currentThread().isInterrupted());
            assertTrue(client.executor.isShutdown());
        } finally {
            Thread.interrupted();
            client.executor.shutdownNow();
            assertTrue(client.executor.awaitTermination(2, TimeUnit.SECONDS));
        }
    }

    @Test
    public void shutdownIsRepeatableAndPreventsRestart() {
        Client client = client();
        try {
            client.close(true);
            client.close(true);
            assertTrue(client.executor.isTerminated());
            try {
                client.start();
                fail("Restart after executor shutdown must fail before network access");
            } catch (IllegalStateException expected) {
                assertTrue(client.userClosed);
            }
        } finally {
            client.executor.shutdownNow();
        }
    }

    @Test
    public void negativeTimeoutDoesNotCloseClient() {
        Client client = client();
        try {
            try {
                client.close(true, -1);
                fail("Negative timeout must be rejected");
            } catch (IllegalArgumentException expected) {
                assertFalse(client.userClosed);
                assertFalse(client.executor.isShutdown());
            }
        } finally {
            client.executor.shutdownNow();
        }
    }
}
