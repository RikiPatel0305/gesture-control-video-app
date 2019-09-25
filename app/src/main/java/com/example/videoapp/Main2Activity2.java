package com.example.videoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class Main2Activity2 extends AppCompatActivity implements GestureDetector.OnGestureListener{

    public static final int SWIPE_THRESHOLD = 100;
    public static final int VELOCITY_THRESHOLD = 100;
    private GestureDetector gestureDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main22);
        gestureDetector = new GestureDetector(this);
    }
//    public boolean onTouchEvent(MotionEvent event) {
//        float x1 = 0,x2;//,y1,y2;
//        switch(event.getAction())
//        {
//            case MotionEvent.ACTION_DOWN:
//                x1=event.getX();
//                // y1=event.getY();
//                break;
//            case MotionEvent.ACTION_UP:
//                x2=event.getX();
//                // y2=event.getY();
//                if(x1<x2)
//                {
//                    //Toast.makeText(this, "Swiped left", Toast.LENGTH_SHORT).show();
//                    finish();
//                    Animatoo.animateSlideLeft(this);
//                }
//                else if(x1>x2)
//                {
//                    int c=1;
//// Intent intent=new Intent(MainActivity.this,com.example.slidevideo.Main2Activity.class);
////                    startActivity(intent);
////                    overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
////                    openActivity2();
//                }
//                break;
//
//
//        }
//
//        return false;
//    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Animatoo.animateSlideLeft(this);
    }


    @Override
    public void finish() {
        super.finish();
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
                }
                else
                {
                    //swipe left
                    finish();
                    Animatoo.animateSlideLeft(this);
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
                }
                else
                {
                    //swipe up
                }
            }
        }
        return false;
    }
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);

        return super.onTouchEvent(event);
    }

}
