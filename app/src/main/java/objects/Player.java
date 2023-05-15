package objects;

import com.example.mylibrary.Core;
import com.example.mylibrary.Graphics;
import com.example.mylibrary.ObjectFW;
import Utilits.UtilResource;

import com.example.mylibrary.AnimationGame;

public class Player extends ObjectFW {
    final int GRAVITY = -3;
    final  int MAX_SPEED =12;
    final int MIN_SPEED= 8;
    AnimationGame animSpritePlayer;
    AnimationGame animPlayerBoost;
    Core core;

    boolean boosting;

    public Player(Core core, int maxScreenX, int maxScreenY, int minScreenY) {
        x = 50;
        y = 100;
        speed = 1;
        boosting = false;
        this.core = core;
        this.maxScreenX = maxScreenX;
        this.maxScreenY = maxScreenY - UtilResource.spritePlayer.get(0).getHeight();
        animSpritePlayer=new AnimationGame(1, UtilResource.spritePlayer.get(0), UtilResource.spritePlayer.get(1), UtilResource.spritePlayer.get(2), UtilResource.spritePlayer.get(3));
        animPlayerBoost=new AnimationGame(1, UtilResource.spritePlayerBoost.get(0), UtilResource.spritePlayerBoost.get(1), UtilResource.spritePlayerBoost.get(2), UtilResource.spritePlayerBoost.get(3));
    }
    public void update(){

        if (core.getTouchListener().getTouchDown(0,maxScreenY,maxScreenX,maxScreenY)){
            startBoosting();
        }
        if (core.getTouchListener().getTouchUp(0,maxScreenY,maxScreenX,maxScreenY)){
            stopBoosting();
        }

        if(boosting){
            speed+=0.1;
        }
        else {
            speed-=3;
        }
        if(speed>MAX_SPEED){
            speed = MAX_SPEED;
        }
        if(speed<MIN_SPEED){
            speed=MIN_SPEED;
        }

        y-=speed+GRAVITY;
        if(y<minScreenY){
            y=minScreenY;
        }
        if(y>maxScreenY){
            y=maxScreenY;
        }

        if(boosting){
            animPlayerBoost.runAnimation();
        }
        else {
            animSpritePlayer.runAnimation();
        }
    }
    private void startBoosting() {
        boosting = true;
    }
    private void stopBoosting() {
        boosting = false;
    }
    public void drawing(Graphics graphics){
        if(boosting=true){
            animPlayerBoost.drawingAnimation(graphics,x,y);
        }
        else {
            animSpritePlayer.drawingAnimation(graphics, x, y);
        }
    }
}
