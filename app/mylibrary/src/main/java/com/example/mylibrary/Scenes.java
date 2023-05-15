package com.example.mylibrary;

public abstract class Scenes {
    public Core core;
    public int scene_width;
    public int scene_height;
    public Graphics graphics;

    public Scenes(Core core) {
        this.core = core;
        scene_width = core.getGraphics().getWidthFrameBuffer();
        scene_height = core.getGraphics().getHeightFrameBuffer();
        graphics = core.getGraphics();



    }
    public abstract void update ();
    public abstract void drawing();
    public abstract void pause();
    public abstract void resume();
    public abstract void dispose();



}
