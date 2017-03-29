package com.github.wangkangmao.domain.base;

/**
 * @author wangkangmao
 * @desc 业务的执行者
 * @date 2017/3/29 10:47
 * @email: kangmao.wang.@foxmail.com
 */
public interface Interactor<T> {

    void execute(T task);
}
