package com.jalenwinslow.game.gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jalenwinslow.game.Handler;

public abstract class GameObject {

    protected Handler handler;
    protected float x, y;

    public GameObject(Handler handler, float x, float y) {
        this.handler = handler;
        this.x = x;
        this.y = y;
    }

    //Main Methods
    public void init(){}
    public abstract void update(float dt);
    public abstract void render(SpriteBatch batch);
    public abstract void dispose();

    //Getters and Setters
    public float getX() {return x;}
    public float getY() {return y;}

    public void setX(float x) {this.x = x;}
    public void setY(float y) {this.y = y;}
}
