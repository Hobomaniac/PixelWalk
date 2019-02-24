package com.jalenwinslow.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jalenwinslow.game.Handler;

public abstract class State {

    public static State currentState = null;
    protected Handler handler;

    public State(Handler handler) {
        this.handler = handler;
    }

    public void init() {}
    public abstract void update(float dt);
    public abstract void render(SpriteBatch batch);
    public abstract void dispose();

}
