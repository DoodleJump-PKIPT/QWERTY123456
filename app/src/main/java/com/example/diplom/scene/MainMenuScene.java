package com.example.diplom.scene;

import android.graphics.Color;

import com.example.diplom.R;
import com.example.mylibrary.Core;
import com.example.mylibrary.Scenes;


public class MainMenuScene extends Scenes {


    public MainMenuScene(Core core) {
        super(core);
    }

    @Override
    public void update() {

        if(core.getTouchListener().getTouchUp(20, 300,200,90)){
            core.setScene(new GameScene(core));
        }

    }

    @Override
    public void drawing() {
        graphics.CLearScene(Color.YELLOW);
        graphics.DrawText(core.getString(R.string.txt_mainMenu_nameGame),500, 100, Color.GRAY, 100, null );
        graphics.DrawText(core.getString(R.string.txt_mainMenu_newGame),20, 300, Color.GRAY, 80, null );
        graphics.DrawText(core.getString(R.string.txt_mainMenu_settingsGame),20, 385, Color.GRAY, 80, null );
        graphics.DrawText(core.getString(R.string.txt_mainMenu_resultGame),20, 470, Color.GRAY, 80, null );
        graphics.DrawText(core.getString(R.string.txt_mainMenu_exitGame),20, 555, Color.GRAY, 80, null );



    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
