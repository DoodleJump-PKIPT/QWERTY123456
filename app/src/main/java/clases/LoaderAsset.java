package clases;

import com.example.mylibrary.Core;
import com.example.mylibrary.Graphics;
import Utilits.UtilResource;

import java.util.ArrayList;

public class LoaderAsset {
    public LoaderAsset(Core core, Graphics graphics) {
        loadTexture(graphics);
        loadSpritePlayer(graphics);
    }

    private void loadSpritePlayer(Graphics graphics) {
        UtilResource.spritePlayer=new ArrayList<>();
        UtilResource.spritePlayerBoost=new ArrayList<>();
        UtilResource.spritePlayer.add(graphics.newSprite(UtilResource.skull, 0, 0 , 200, 200));
        UtilResource.spritePlayer.add(graphics.newSprite(UtilResource.skull, 230, 0 , 200, 214));
        UtilResource.spritePlayer.add(graphics.newSprite(UtilResource.skull, 430, 0 , 213, 215));
        UtilResource.spritePlayer.add(graphics.newSprite(UtilResource.skull, 630, 0 , 210, 230));

        UtilResource.spritePlayerBoost.add(graphics.newSprite(UtilResource.skull, 0, 200 , 194, 232));
        UtilResource.spritePlayerBoost.add(graphics.newSprite(UtilResource.skull, 204, 230 , 216, 232));
        UtilResource.spritePlayerBoost.add(graphics.newSprite(UtilResource.skull, 650, 230, 217, 236));
        UtilResource.spritePlayerBoost.add(graphics.newSprite(UtilResource.skull, 800, 230, 220, 261));
    }
    private void loadTexture(Graphics graphics) {
        UtilResource.skull = graphics.newTexture("skull.png");
    }
}
