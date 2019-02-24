package com.jalenwinslow.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jalenwinslow.game.states.GameState;
import com.jalenwinslow.game.states.State;
import com.jalenwinslow.game.utils.Controls;

public class Handler {

    private Main main;
    public OrthographicCamera cam;

    private State gameState;

    public Handler(Main main, OrthographicCamera cam) {
        this.main = main;
        this.cam = cam;
    }

    //Main Methods
    public void init() {
        gameState = new GameState(this);
        State.currentState = gameState;
        State.currentState.init();
    }

    public void update(float dt) {
        Controls.update(dt);
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
    public GameState getGameState() {return (GameState) gameState;}
}
