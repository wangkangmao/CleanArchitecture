package com.github.wangkangmao.presenter;


import com.github.wangkangmao.data.executor.JobExecutor;
import com.github.wangkangmao.data.executor.UIExecutor;
import com.github.wangkangmao.data.repository.GetPosterImageRepository;
import com.github.wangkangmao.data.repository.GetPosterTitleRepository;
import com.github.wangkangmao.domain.base.DefaultSubscriber;
import com.github.wangkangmao.domain.interactors.GetPosterImageInteractor;
import com.github.wangkangmao.domain.interactors.GetPosterTitleInteractor;
import com.github.wangkangmao.presenter.contract.PosterContract;

/**
 * @author wangkangmao
 * @desc
 * @date 2017/3/29 10:38
 * @email: kangmao.wang.@foxmail.com
 */
public class PosterPresenter implements PosterContract.Presenter {

    GetPosterImageInteractor mImageInteractor;
    GetPosterTitleInteractor mTitleInteractor;
    PosterContract.View mView;

    public PosterPresenter(PosterContract.View view) {
        this.mView = view;
        this.mImageInteractor = new GetPosterImageInteractor(new JobExecutor(), new UIExecutor(), new GetPosterImageRepository());
        this.mTitleInteractor = new GetPosterTitleInteractor(new JobExecutor(), new UIExecutor(), new GetPosterTitleRepository());
    }

    @Override
    public void getPostImage() {
        mImageInteractor.execute(new DefaultSubscriber<String>() {
            @Override
            public void onNext(String s) {
                mView.setPosterImage(s);
            }
        });

    }

    @Override
    public void getPosterTitle() {
        mTitleInteractor.execute(new DefaultSubscriber<String>() {
            @Override
            public void onNext(String s) {
                mView.setPosterTitle(s);
            }
        });
    }
}
