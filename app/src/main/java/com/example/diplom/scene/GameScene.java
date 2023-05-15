package com.example.diplom.scene;

import android.graphics.Color;

import com.example.diplom.R;
import com.example.mylibrary.Core;
import com.example.mylibrary.Scenes;

import clases.GameManager;
import generators.GeneratorBackground;

public class GameScene extends Scenes {

    enum GameState {
        READY, RUNNING, PAUSE, GAMEOVER
    }
    GameState gameState;
    GeneratorBackground generatorBackground;
    GameManager gameManager;

    public GameScene(Core core) {
        super(core);
        gameState = GameState.READY;
        generatorBackground = new GeneratorBackground(scene_width, scene_height);
        gameManager = new GameManager(core, scene_width, scene_height);
    }
    @Override
    public void update() {
        if(gameState==GameState.READY){
            updateStateReady();
        }
        if(gameState==GameState.RUNNING){
            updateStateRunning();
        }
        if(gameState==GameState.PAUSE){
            updateStatePause();
        }
        if(gameState==GameState.GAMEOVER){
            updateStateGameOver();
        }
    }
    private void updateStateReady() {
        if (core.getTouchListener().getTouchUp(0, scene_height,scene_width,scene_height)){
            gameState = GameState.RUNNING;
        }
    }
    private void updateStateRunning() {
        generatorBackground.update();
        gameManager.update();
    }
    private void updateStatePause() {
    }
    private void updateStateGameOver() {
    }
    @Override
    public void drawing() {
        graphics.CLearScene(Color.RED);
        if(gameState==GameState.READY){
            drawingStateReady();
        }
        if(gameState==GameState.RUNNING){
            drawingStateRunning();
        }
        if(gameState==GameState.PAUSE){
            drawingStatePause();
        }
        if(gameState==GameState.GAMEOVER){
            drawingStateGameOver();
        }
    }
    private void drawingStateReady() {
        graphics.CLearScene(Color.RED);
        graphics.DrawText(core.getString(R.string.txt_GameScene_stateReady_ready),750,900,Color.BLACK, 80, null );
    }
    private void drawingStateRunning() {
        graphics.CLearScene(Color.BLACK);
        generatorBackground.drawing(graphics);
        gameManager.drawing(core, graphics);
    }
    private void drawingStatePause() {
    }
    private void drawingStateGameOver() {
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
