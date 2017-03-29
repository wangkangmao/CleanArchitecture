package com.github.wangkangmao.domain.interactors;

import com.github.wangkangmao.domain.base.AbstractInteractor;
import com.github.wangkangmao.domain.base.Repository;
import com.github.wangkangmao.domain.executors.PostExecutor;
import com.github.wangkangmao.domain.executors.ThreadExecutor;

import rx.Observable;

/**
 * @author wangkangmao
 * @version $version$
 * @desc $desc$
 * @date $date$ $time$
 * @email: kangmao.wang.@foxmail.com
 */
public class GetPosterImageInteractor extends AbstractInteractor<String> {

    private Repository<String> mRepository;

    public GetPosterImageInteractor(ThreadExecutor threadExecutor, PostExecutor postExecutor, Repository<String> repository) {
        super(threadExecutor, postExecutor);
        this.mRepository = repository;
    }

    @Override
    public Observable<String> buildObservable() {
        return mRepository.getObservable();
    }
}
