package com.github.wangkangmao.domain.base;

import com.github.wangkangmao.domain.executors.PostExecutor;
import com.github.wangkangmao.domain.executors.ThreadExecutor;

import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * @author wangkangmao
 * @desc 抽象层面的Interactor
 * @date 2017/3/29 11:03
 * @email: kangmao.wang.@foxmail.com
 */
public abstract class AbstractInteractor<T> implements Interactor<Subscriber> {

    private CompositeSubscription mCompositeSubscription = new CompositeSubscription();
    private ThreadExecutor mThreadExecutor;
    private PostExecutor mPostExecutor;

    public AbstractInteractor(ThreadExecutor threadExecutor, PostExecutor postExecutor) {
        this.mThreadExecutor = threadExecutor;
        this.mPostExecutor = postExecutor;
    }

    public abstract Observable<T> buildObservable();

    @Override
    public void execute(Subscriber task) {
        mCompositeSubscription.add(task);
        buildObservable().subscribeOn(Schedulers.from(mThreadExecutor))
                .observeOn(mPostExecutor.getScheduler())
                .subscribe(task);
    }

    public void unSubscribe() {
        mCompositeSubscription.clear();
    }
}
