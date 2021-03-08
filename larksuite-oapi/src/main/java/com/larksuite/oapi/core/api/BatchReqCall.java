package com.larksuite.oapi.core.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class BatchReqCall<I, O> {

    private static final ExecutorService defaultExecutorService = Executors.newCachedThreadPool(new ThreadFactory() {
        protected final AtomicInteger mThreadNum = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable runnable) {
            String mPrefix = "larksuite-oapi-thread-";
            String name = mPrefix + mThreadNum.getAndIncrement();
            return new Thread(null, runnable, name, 0);
        }
    });

    private final ExecutorService executorService;
    private final List<ReqCaller<I, O>> reqCallers;


    @SafeVarargs
    public BatchReqCall(ReqCaller<I, O>... reqCallers) {
        this(defaultExecutorService, reqCallers);
    }

    @SafeVarargs
    public BatchReqCall(ExecutorService executorService, ReqCaller<I, O>... reqCallers) {
        this.executorService = executorService;
        this.reqCallers = new ArrayList<>();
        int i = 0;
        for (ReqCaller<I, O> reqCaller : reqCallers) {
            reqCaller.setIdx$$(i);
            this.reqCallers.add(reqCaller);
            i++;
        }
    }

    public List<ReqCallResult<I, O>> call() throws InterruptedException, ExecutionException {
        List<ReqCallResult<I, O>> reqCallResults = new ArrayList<>();
        if (this.reqCallers.size() == 0) {
            return reqCallResults;
        }
        List<Future<ReqCaller<I, O>>> futures = executorService.invokeAll(this.reqCallers);
        for (Future<ReqCaller<I, O>> future : futures) {
            ReqCallResult<I, O> reqCallResult = new ReqCallResult<>(future.get());
            reqCallResults.add(reqCallResult);
        }
        reqCallResults.sort(Comparator.comparingInt(o -> o.getReqCaller().getIdx$$()));
        return reqCallResults;
    }

}
