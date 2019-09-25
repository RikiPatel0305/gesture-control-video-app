package com.example.videoapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;
import android.widget.VideoView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class  MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener{

    public static final int SWIPE_THRESHOLD = 100;
    public static final int VELOCITY_THRESHOLD = 100;

    int rikin1;
    float x1,x2,y1,y2;
    VideoView vv1;
    MediaPlayer mMediaPlayer;
    int mCurrentVideoPosition;
    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vv1=findViewById(R.id.vv1);
        String uripath1="android.resource://com.example.videoapp/"+R.raw.highway;
        Uri uri1=Uri.parse(uripath1);
        vv1.setVideoPath(uri1.toString());
        vv1.requestFocus();
        vv1.start();
    vv1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
        @Override
        public void onPrepared(MediaPlayer mp) {
            mMediaPlayer=mp;
            mMediaPlayer.setLooping(true);
            if(mCurrentVideoPosition != 0)
            {
                mMediaPlayer.seekTo(mCurrentVideoPosition);
                mMediaPlayer.start();
            }

        }
    });
        gestureDetector = new GestureDetector(this);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        vv1=findViewById(R.id.vv1);
        String uripath1="android.resource://com.example.videoapp/"+R.raw.highway;
        Uri uri1=Uri.parse(uripath1);
        vv1.setVideoPath(uri1.toString());
        vv1.requestFocus();
        vv1.start();
        vv1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mMediaPlayer=mp;
                mMediaPlayer.setLooping(true);
                if(mCurrentVideoPosition != 0)
                {
                    mMediaPlayer.seekTo(mCurrentVideoPosition);
                    mMediaPlayer.start();
                }

            }
        });
    }

    //@Override
//    public boolean onTouchEvent(MotionEvent event) {
//        switch(event.getAction())
//        {
//            case MotionEvent.ACTION_DOWN:
//                x1=event.getX();
//                y1=event.getY();
//                break;
//            case MotionEvent.ACTION_UP:
//                x2=event.getX();
//                y2=event.getY();
//                if(x1<x2)
//                {
//                   // Toast.makeText(this, "Swiped left", Toast.LENGTH_SHORT).show();
//                    openDialog();
//                }
//                else if(x1>x2)
//                {
//                    Intent intent=new Intent(MainActivity.this,com.example.videoapp.Main2Activity.class);
//                    startActivity(intent);
//                    Animatoo.animateSlideLeft(this);
//                }
//                else if(y1>y2)
//                {
//                    Intent intent=new Intent(MainActivity.this,com.example.videoapp.MainActivity2.class);
//                    startActivity(intent);
//                    Animatoo.animateSlideUp(this);
//                }
//                break;
//
//
//        }
//
//        return false;
//    }

    public void openDialog() {
        ExampleDialog1 ed1=new ExampleDialog1();
        //ExampleDialog ed=new ExampleDialog();
        ed1.show(getSupportFragmentManager(), "example dialog");
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent downEvent, MotionEvent moveEvent, float velocityX, float velocityY) {
        float diffY =moveEvent.getY()- downEvent.getY();
        float diffX =moveEvent.getX()- downEvent.getX();
        if(Math.abs(diffX) > Math.abs(diffY))
        {
            //right or left swipe
            if(Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > VELOCITY_THRESHOLD)
            {
                if(diffX > 0)
                {
                    //swipe right
                    onSwipeRight();

                }
                else
                {
                    openDialog();
                    //swipe left

                }
            }
        }
        else
        {
            //up or down swipe
            if(Math.abs(diffY)>SWIPE_THRESHOLD && Math.abs(velocityY)>VELOCITY_THRESHOLD)
            {
                if(diffY > 0)
                {
                    //swipe down
                    Intent intent=new Intent(MainActivity.this,com.example.videoapp.MainActivity5.class);
                    startActivity(intent);
                    Animatoo.animateSlideDown(this);
                }
                else
                {
                    //swipe up
                    Intent intent=new Intent(MainActivity.this,com.example.videoapp.MainActivity2.class);
                    startActivity(intent);
                    Animatoo.animateSlideUp(this);
                }
            }
        }
        return false;
    }

    private void onSwipeRight() {
        Intent intent=new Intent(MainActivity.this,com.example.videoapp.Main2Activity.class);
        startActivity(intent);
        Animatoo.animateSlideRight(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);

        return super.onTouchEvent(event);
    }
    long backPressedTime;
    @Override
    public void onBackPressed() {
        finishAffinity();
        System.exit(0);
//        if(backPressedTime + 2000 > System.currentTimeMillis())
//        {
//            finish();
//            System.exit(0);
//            return;
//        }
//        else
//        {
//            Toast.makeText(this, "press back again to exit", Toast.LENGTH_SHORT).show();
//        }
//        backPressedTime=System.currentTimeMillis();
    }

    @Override
    public void finish() {
        super.finish();
    }
}
