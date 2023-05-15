package generators;

import android.graphics.Color;

import com.example.mylibrary.Graphics;

import java.util.ArrayList;

import objects.Star;

public class GeneratorBackground {
    public ArrayList<Star> starArrayList=new ArrayList<Star>();
    public GeneratorBackground(int sceneWidth, int sceneHeight ){
        int starsSpeak = 50;
        for (int i = 0; i < starsSpeak ; i++){
            Star star = new Star(sceneWidth,sceneHeight);
            starArrayList.add(star);


        }

    }
    public void update(){
        for (int i = 0; i < starArrayList.size(); i++) {
            starArrayList.get(i).update();

        }
    }

    public void drawing (Graphics graphics){
        for (int i = 0; i < starArrayList.size(); i++) {
            graphics.DrawPixel(starArrayList.get(i).getX(),starArrayList.get(i).getY(), Color.WHITE);
        }
    }
}
