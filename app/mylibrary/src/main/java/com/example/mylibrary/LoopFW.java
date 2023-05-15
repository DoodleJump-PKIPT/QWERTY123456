package com.example.mylibrary;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.icu.text.BidiRun;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class LoopFW extends SurfaceView implements Runnable {

    private final float FPS = 60;
    private final float SECOND = 1000000000;
    private final float UPDATE_TIME = SECOND/FPS;

    private boolean running = false;

    Thread gameThread = null;
    Core core;
    Bitmap frameBuffer;
    SurfaceHolder surfaceHolder;
    Canvas canvas;
    Rect rect;

    public LoopFW( Core core, Bitmap frameBuffer){
     super(core);
     this.frameBuffer = frameBuffer;
     this.core = core;
     this.surfaceHolder = getHolder();
     rect = new Rect();
     canvas = new Canvas();

    }


    private void update_game(){
        core.getCurrentScene().update();

    }

    private  void drawing_game(){
        if(surfaceHolder.getSurface().isValid()){
            canvas = surfaceHolder.lockCanvas();
            canvas.getClipBounds(rect);
            canvas.drawBitmap(frameBuffer, null, rect, null);
            core.getCurrentScene().drawing();
            surfaceHolder.unlockCanvasAndPost(canvas);

        }

    }
 public void run(){
        float last_time = System.nanoTime();
        float help1 = 0;

     while (running){
         float now_time = System.nanoTime();
         float elapsed_time = now_time - last_time;
         last_time = now_time;
         help1 += elapsed_time/UPDATE_TIME;
         if (help1 > 1){
             update_game();
             drawing_game();
             help1--;

         }

}

 }
 public void START(){
     if(running){
         return;
     }
     else {
         running = true;
         gameThread = new Thread(this::run);
         gameThread.start();
     }
 }
 public void STOP(){
     if(!running){
         return;
     }
     else {
         running = false;
         try {
             gameThread.join();
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }
 }
}
