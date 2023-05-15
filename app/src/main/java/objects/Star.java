package objects;

import com.example.mylibrary.ObjectFW;
import com.example.mylibrary.utilits.UtillRandomFW;

public class Star extends ObjectFW {

    public Star(int sceneWidth, int sceneHeight){
        this.maxScreenX=sceneWidth;
        this.maxScreenY=sceneHeight;
        this.minScreenX=0;
        this.minScreenY=0;
        this.speed = 2;
        this.y= UtillRandomFW.getCasualNumber(maxScreenY);
        this.x = UtillRandomFW.getCasualNumber(maxScreenX);


    }

    public void update (){
        x-=speed;
        if(x<0){
            x= UtillRandomFW.getCasualNumber(maxScreenX);
            y= UtillRandomFW.getCasualNumber(maxScreenY);

        }
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}
