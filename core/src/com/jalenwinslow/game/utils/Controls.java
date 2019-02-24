package com.jalenwinslow.game.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Controls {

    public static boolean right, left, up, down;

    public static void update(float dt) {
        checkKeys();
    }

    private static void checkKeys() {
        right = Gdx.input.isKeyJustPressed(Input.Keys.D);
        left = Gdx.input.isKeyJustPressed(Input.Keys.A);
        up = Gdx.input.isKeyJustPressed(Input.Keys.W);
        down = Gdx.input.isKeyJustPressed(Input.Keys.S);
    }

}
