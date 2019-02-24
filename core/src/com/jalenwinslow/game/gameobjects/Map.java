package com.jalenwinslow.game.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jalenwinslow.game.Handler;
import com.jalenwinslow.game.utils.Assets;
import com.jalenwinslow.game.utils.MapReader;

public class Map extends GameObject {

    public int[][] map;
    private Pixmap pixmap;
    private Texture pixmapTex;

    public Map(Handler handler, float x, float y) {
        super(handler, x , y);
        /*
        map = new int[10][10];
        for (int j = 0; j < map.length; j++) {
            for (int i = 0; i < map[j].length; i++) {
                if (j == 0 || j == map.length-1) map[j][i] = 1;
                if (i == 0 || i == map[j].length-1) map[j][i] = 1;
            }
        }*/
        init();
    }

    public void init() {
        map = MapReader.readMap(Assets.map1);
        pixmap = new Pixmap(map[0].length, map.length, Pixmap.Format.RGBA8888);
        for (int j = 0; j < map.length; j++) {
            for (int i = 0 ; i < map[j].length; i++) {
                if (map[j][i] == 1) pixmap.setColor(Color.BLACK);
                else pixmap.setColor(Color.WHITE);
                pixmap.drawPixel(i, j);
            }
        }
        pixmapTex = new Texture(pixmap);
        pixmap.dispose();
    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(pixmapTex, 0 , 0);
    }

    @Override
    public void dispose() {

    }

    //Getters and Setters
}
