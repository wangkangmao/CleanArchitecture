package com.github.wangkangmao.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.github.wangkangmao.R;
import com.github.wangkangmao.presenter.PosterPresenter;
import com.github.wangkangmao.presenter.contract.PosterContract;

public class PosterActivity extends AppCompatActivity implements PosterContract.View {

    private PosterPresenter mPosterPresenter;
    private ImageView mIv;
    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPosterPresenter = new PosterPresenter(this);
        initView();
        initData();
    }

    private void initView() {
        mIv = (ImageView) findViewById(R.id.lv);
        mTv = (TextView) findViewById(R.id.tv);
    }

    private void initData() {
        mPosterPresenter.getPostImage();
        mPosterPresenter.getPosterTitle();
    }

    @Override
    public void setPosterImage(String url) {
        Glide.with(this).load(url).into(mIv);
    }

    @Override
    public void setPosterTitle(String title) {
        mTv.setText(title);
    }
}
