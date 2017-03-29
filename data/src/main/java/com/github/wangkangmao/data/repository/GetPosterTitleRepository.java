package com.github.wangkangmao.data.repository;

import com.github.wangkangmao.domain.base.Repository;

import rx.Observable;

/**
 * @author wangkangmao
 * @desc 获取海报标题数据
 * @date 2017/3/29 11:47
 * @email: kangmao.wang.@foxmail.com
 */
public class GetPosterTitleRepository implements Repository<String> {
    @Override
    public Observable<String> getObservable() {
        return Observable.just("niuniu~~");
    }
}
