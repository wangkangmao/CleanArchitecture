package com.github.wangkangmao.data.executor;

import com.github.wangkangmao.domain.executors.PostExecutor;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;

/**
 * @author wangkangmao
 * @desc UI调度器
 * @date 2017/3/29 14:57
 * @email: kangmao.wang.@foxmail.com
 */
public class UIExecutor implements PostExecutor {

    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
