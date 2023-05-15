package com.example.mylibrary;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;

import java.io.IOException;
import java.io.InputStream;

public class Graphics {
    private AssetManager assetManagerGame;
    private Bitmap frameBufferGame;
    private Canvas canvasGame;
    private Paint paintGame;
    private Bitmap textureGame;

    public Graphics(AssetManager assetManager, Bitmap frameBufferGame) {
        this.assetManagerGame = assetManager;
        this.frameBufferGame = frameBufferGame;
        this.canvasGame = new Canvas(frameBufferGame);
        this.paintGame = new Paint();
    }
    public void DrawPixel(int x, int y, int color) {
        paintGame.setColor(color);
        canvasGame.drawPoint(x, y, paintGame);
    }
    public void CLearScene(int colorRGB) {
        canvasGame.drawRGB(colorRGB, colorRGB, colorRGB);
    }
    public void LinePixel(int start_x, int stop_x, int start_y, int stop_y, int color) {
        paintGame.setColor(color);
        canvasGame.drawLine(start_x, start_y, stop_x, stop_y, paintGame);
    }
    public void DrawText(String text, int x, int y, int color, int size_text, Typeface font) {
        paintGame.setColor(color);
        paintGame.setTextSize(size_text);
        paintGame.setTypeface(font);
        canvasGame.drawText(text, x, y, paintGame);
    }
    public void DrawTexture(Bitmap textureGame, int x, int y) {
        canvasGame.drawBitmap(textureGame, x, y, null);
    }
    public int getWidthFrameBuffer() {
       return frameBufferGame.getWidth();
    }
    public int getHeightFrameBuffer() {
        return frameBufferGame.getHeight();
    }
    public Bitmap newTexture(String file_name){
        InputStream inputStream = null;
        try {
            inputStream = assetManagerGame.open(file_name);
            textureGame = BitmapFactory.decodeStream(inputStream);
            if (textureGame == null){
                throw new RuntimeException("Не возможно загрузить файл"+ file_name);
            }
        } catch (IOException e) {
            throw new RuntimeException("Не возможно загрузить файл"+ file_name);
        }
        if (inputStream!= null){
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return textureGame;
    }
    public Bitmap newSprite(Bitmap textureAlas, int x, int y, int widthSprite, int heightSprite){
        Bitmap newSprite = Bitmap.createBitmap(textureAlas, x , y ,widthSprite, heightSprite);
        return newSprite;
    }
}
