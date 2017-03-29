package com.github.wangkangmao.domain.base;


import rx.Observable;

/**
 * @author wangkangmao
 * @desc 观察者仓库
 * @date 2017/3/29 11:08
 * @email: kangmao.wang.@foxmail.com
 */
public interface Repository<T> {

    Observable<T> getObservable();
}
