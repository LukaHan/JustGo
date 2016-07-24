package com.luka.jounery.justgo.video;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;

import com.luka.jounery.justgo.R;
import com.luka.jounery.justgo.base.BaseActivity;

import java.io.IOException;

/**
 * Created by Luka on 2016/7/22.
 * 397308937@qq.com
 */
public class PlayerActivity extends BaseActivity {

    private SurfaceView surfaceViewPlay;
    private String path;
    private MediaPlayer mediaPlayer;
    private boolean isSurfaceCreated;
    private ImageView ivPlay;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_player);
        path = getIntent().getStringExtra("path");
        initView();
        init();
    }

    private void init() {
        mediaPlayer = new MediaPlayer();
        
        surfaceViewPlay.getHolder().setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        surfaceViewPlay.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                isSurfaceCreated = true;
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });
    }

    private void play() {
        try {
            mediaPlayer.reset();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setDataSource(path);

            mediaPlayer.setDisplay(surfaceViewPlay.getHolder());
            mediaPlayer.prepare();
            mediaPlayer.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initView() {
        surfaceViewPlay = (SurfaceView) findViewById(R.id.surfaceViewPlay);
        surfaceViewPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isSurfaceCreated){
                    if(mediaPlayer.isPlaying()){
                        ivPlay.setVisibility(View.VISIBLE);
                        mediaPlayer.pause();
                    }else{
                        ivPlay.setVisibility(View.GONE);
                        play();
                    }
                }
            }
        });
        ivPlay = (ImageView) findViewById(R.id.ivPlay);
    }
}
