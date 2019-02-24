package com.jalenwinslow.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jalenwinslow.game.states.GameState;
import com.jalenwinslow.game.states.State;

public class Handler {

    private Main main;

    private State gameState;

    public Handler(Main main) {
        this.main = main;
    }

    //Main Methods
    public void init() {
        gameState = new GameState(this);
        State.currentState = gameState;
    }

    public void update(float dt) {
        if (State.currentState != null) {
            State.currentState.update(dt);
        }
    }

    public void render(SpriteBatch batch) {
        if (State.currentState != null) {
            State.currentState.render(batch);
        }
    }

    public void dispose() {
        gameState.dispose();
    }

    //Getters and Setters
}
