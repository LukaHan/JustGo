package com.luka.jounery.justgo.video;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.luka.jounery.justgo.R;
import com.luka.jounery.justgo.base.BaseActivity;

/**
 * Created by Luka on 2016/7/22.
 * 397308937@qq.com
 */
public class VideoActivity extends BaseActivity implements View.OnClickListener {

    private MovieRecorderView movieRecorderView;
    private ImageView ivRecord;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_video);
        initView();
        initListener();
    }


    private void initView() {
        movieRecorderView = (MovieRecorderView) findViewById(R.id.movieRecorderView);
        ivRecord = (ImageView) findViewById(R.id.ivRecord);

    }

    private void initListener() {
        findViewById(R.id.ivNext).setOnClickListener(this);
        findViewById(R.id.ivBack).setOnClickListener(this);

        ivRecord.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.d("hehe", "ACTION_DOWN");
                        movieRecorderView.record(new MovieRecorderView.OnRecordFinishListener() {
                            @Override
                            public void onRecordFinish() {
                                Log.d("hehe", "onRecordFinish");
                            }
                        });
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.d("hehe", "ACTION_UP");
                        movieRecorderView.stopRecord();
                        break;
                }
                return true;
            }
        });

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ivNext:
                Intent intent = new Intent(VideoActivity.this,PlayerActivity.class);
                String path = movieRecorderView.getmVecordFile().getAbsolutePath();
                intent.putExtra("path",path);
                Log.d("hehe",path);
                startActivity(intent);
                break;
            case R.id.ivBack:
                VideoActivity.this.finish();
                break;
        }
    }
}
