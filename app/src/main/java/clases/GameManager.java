package clases;

import com.example.mylibrary.Core;
import com.example.mylibrary.Graphics;

import objects.Player;

public class    GameManager {
    private int maxScreenY;
    private int maxScreenX;
    private int minScreenY;
    private int minScreenX;

    Player player;

    public GameManager(Core core, int sceneWidth, int sceneHeight) {
        this.maxScreenX=sceneWidth;
        this.maxScreenY=sceneHeight;
        minScreenX=0;
        minScreenY=0;
        player = new Player(core,maxScreenX, maxScreenY, minScreenY);
    }
    public void  update(){
        player.update();
    }
    public void drawing(Core core, Graphics graphics){
        player.drawing(graphics);
    }
}
