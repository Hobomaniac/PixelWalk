package com.jalenwinslow.game.utils;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Assets {

    public static String map1 = "Map1.txt";
    public static Texture mapT = new Texture(Gdx.files.internal("Map1.png"));


    public static void dispose() {
        mapT.dispose();
    }
}
