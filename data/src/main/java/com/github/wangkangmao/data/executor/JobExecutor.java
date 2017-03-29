package com.github.wangkangmao.data.executor;

import com.github.wangkangmao.domain.executors.ThreadExecutor;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wangkangmao
 * @desc 真正的任务执行者
 * @date 2017/3/29 11:48
 * @email: kangmao.wang.@foxmail.com
 */
public class JobExecutor implements ThreadExecutor {

    //初始化线程池大小
    private static final int INITIAL_POOL_SIZE = 3;
    //允许的最大线程池大小
    private static final int MAX_POOL_SIZE = 5;

    //设置空闲线程在终止之前等待的时间 10S
    private static final int KEEP_ALIVE_TIME = 10;

    //设置时间单位为 s
    private static final TimeUnit KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;

    private final BlockingDeque<Runnable> mWorkQueue;
    private final ThreadFactory mTheadFactory;
    private final ThreadPoolExecutor mThreadPoolExecutor;

    public JobExecutor() {
        this.mWorkQueue = new LinkedBlockingDeque<>();
        this.mTheadFactory = new JobThreadFactory();
        this.mThreadPoolExecutor = new ThreadPoolExecutor(INITIAL_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME
                , KEEP_ALIVE_TIME_UNIT, this.mWorkQueue, this.mTheadFactory);
    }

    @Override
    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new IllegalArgumentException("Runnable to execute cannot be null");
        }
        this.mThreadPoolExecutor.execute(runnable);

    }

    private static class JobThreadFactory implements ThreadFactory {
        private static final String THREAD_NAME = "android_";
        private int counter = 0;

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, THREAD_NAME + counter++);
        }
    }
}
