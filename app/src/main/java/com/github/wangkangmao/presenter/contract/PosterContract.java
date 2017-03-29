package com.github.wangkangmao.presenter.contract;

import com.github.wangkangmao.presenter.IPresenter;
import com.github.wangkangmao.presenter.IView;

/**
 * @author wangkangmao
 * @desc Poster's Contract
 * @date 2017/3/29 10:42
 * @email: kangmao.wang.@foxmail.com
 */
public interface PosterContract {

    interface View extends IView {
        void setPosterImage(String url);

        void setPosterTitle(String title);
    }

    interface Presenter extends IPresenter {
        void getPostImage();

        void getPosterTitle();
    }
}
