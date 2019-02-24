package com.jalenwinslow.game.gameobjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jalenwinslow.game.Handler;
import com.jalenwinslow.game.utils.Controls;

public class Player extends GameObject {

    Texture t;

    public Player(Handler handler, float x, float y) {
        super(handler, x, y);
        init();
    }

    @Override
    public void init() {
        Pixmap pm = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pm.setColor(Color.GREEN);
        pm.drawPixel(0, 0);
        t = new Texture(pm);

        //handler.cam.position.x = x;
        //handler.cam.position.y = y;
    }

    @Override
    public void update(float dt) {
        controls();
        //updateCam();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(t, x, y);
    }

    @Override
    public void dispose() {

    }

    // Other Methods
    private void controls() {
        if (Controls.right) x += 1;
        else if (Controls.left) x -= 1;
        else if (Controls.up) y += 1;
        else if (Controls.down) y -= 1;
    }

    private void updateCam() {
        handler.cam.position.x = x;
        handler.cam.position.y = y;
    }


    //Getters and Setters


}
