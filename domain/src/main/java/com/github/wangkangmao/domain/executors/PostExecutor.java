package com.github.wangkangmao.domain.executors;

import rx.Scheduler;

/**
 * @author wangkangmao
 * @desc 执行者
 * @date 2017/3/29 10:59
 * @email: kangmao.wang.@foxmail.com
 */
public interface PostExecutor {

    Scheduler getScheduler();
}
