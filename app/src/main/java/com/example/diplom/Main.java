package com.example.diplom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.diplom.scene.MainMenuScene;
import com.example.mylibrary.Core;
import com.example.mylibrary.Graphics;
import com.example.mylibrary.LoopFW;
import com.example.mylibrary.Scenes;

import clases.LoaderAsset;


public class Main extends Core {

    public Scenes getStartScene(){
        LoaderAsset loaderAsset = new LoaderAsset(this, this.getGraphics());
        return new MainMenuScene(this);
    }
}