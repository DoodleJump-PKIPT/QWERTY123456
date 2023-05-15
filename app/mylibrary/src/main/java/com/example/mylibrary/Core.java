package com.example.mylibrary;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Core extends AppCompatActivity{

    private final float FRAME_BUFFER_WIDTH = 1920;
    private final float FRAME_BUFFER_HEIGHT = 1080;

    private LoopFW loopFW;
    private Graphics graphics;
    private TouchListener touchListener;

    private Display display;
    private Point sizeDisplay;
    private Bitmap frameBuffer;
    private Scenes scenes;
    private float sceneWidth;
    private float sceneHeight;

    private boolean stateOnPause;
    private boolean stateOnResume;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        sizeDisplay = new Point();
        display = getWindowManager().getDefaultDisplay();
        display.getSize(sizeDisplay);

        frameBuffer = Bitmap.createBitmap((int)FRAME_BUFFER_WIDTH, (int)FRAME_BUFFER_HEIGHT, Bitmap.Config.ARGB_8888);
        sceneWidth = FRAME_BUFFER_WIDTH/sizeDisplay.x;
        sceneHeight = FRAME_BUFFER_HEIGHT/sizeDisplay.y;

        loopFW = new LoopFW(this, frameBuffer);
        graphics = new Graphics(getAssets(), frameBuffer);

        touchListener = new TouchListener(loopFW, sceneWidth, sceneHeight);

        scenes = getStartScene();
        stateOnPause = false;
        stateOnResume = false;
        setContentView(loopFW);
    }
    public  Core(){
    }
    public void onResume(){
        super.onResume();
        scenes.resume();
        loopFW.START();
    }
    public void onPause(){
        super.onPause();
        scenes.pause();
        loopFW.STOP();
        stateOnPause = true;
        if (isFinishing()){
            scenes.dispose();
        }
    }
    public Graphics getGraphics(){
        return graphics;
    }
    public TouchListener getTouchListener(){
        return touchListener;
    }
    public void setScene(Scenes scenes){
        if(scenes == null ){
            throw new IllegalArgumentException("Невозможно загрузить сцену");
        }
        else {
            this.scenes.pause();
            this.scenes.dispose();
            scenes.resume();
            scenes.update();
            this.scenes = scenes;
        }
    }
    public Scenes getCurrentScene(){
        return scenes;
    }
    public Scenes getStartScene(){
        return scenes;
    }
}
