package com.github.wangkangmao.domain.interactors;

import com.github.wangkangmao.domain.base.AbstractInteractor;
import com.github.wangkangmao.domain.base.Repository;
import com.github.wangkangmao.domain.executors.PostExecutor;
import com.github.wangkangmao.domain.executors.ThreadExecutor;

import rx.Observable;

/**
 * @author wangkangmao
 * @desc 获取海报标题
 * @date 2017/3/29 11:15
 * @email: kangmao.wang.@foxmail.com
 */
public class GetPosterTitleInteractor extends AbstractInteractor<String> {


    private Repository<String> mRepository;

    public GetPosterTitleInteractor(ThreadExecutor threadExecutor, PostExecutor postExecutor, Repository<String> repository) {
        super(threadExecutor, postExecutor);
        this.mRepository = repository;
    }

    @Override
    public Observable<String> buildObservable() {
        return mRepository.getObservable();
    }
}
