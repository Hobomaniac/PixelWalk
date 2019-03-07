package com.jalenwinslow.game.gameobjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jalenwinslow.game.Handler;
import com.jalenwinslow.game.utils.CameraHandler;
import com.jalenwinslow.game.utils.Controls;

public class Player extends GameObject {

    Texture t;
    int vecX, vecY;

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

    }

    @Override
    public void update(float dt) {
        controls();
        checkCollision();
        checkLifeBlock();
        x += vecX;
        y += vecY;
        vecX = 0;
        vecY = 0;
        CameraHandler.updateCam(x, y);
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
        if (Controls.right) vecX = 1;
        else if (Controls.left) vecX = -1;
        else if (Controls.up) vecY = 1;
        else if (Controls.down) vecY = -1;
    }

    private void checkCollision() {
        if (handler.getGameState().getMap().returnPosition((int)x+vecX, (int)y) != 0) vecX = 0;
        if (handler.getGameState().getMap().returnPosition((int)x, (int)y +vecY) != 0) vecY = 0;

    }

    private void checkLifeBlock() {
        LifeBlock lb = null;
        int xx = (int)x;
        int yy = (int)y;
        if (handler.getGameState().getMap().returnPosition( (int)xx+1, (int)yy) == 2) {
            lb = LifeBlock.getLifeBlock(xx+1, yy);
        }
        if (handler.getGameState().getMap().returnPosition( (int)xx-1, (int)yy) == 2) {
            if (lb == null) lb = LifeBlock.getLifeBlock(xx-1, yy);
        }
        if (handler.getGameState().getMap().returnPosition( (int)xx, (int)yy+1) == 2) {
            if (lb == null) lb = LifeBlock.getLifeBlock(xx, yy+1);
        }
        if (handler.getGameState().getMap().returnPosition( (int)xx, (int)yy-1) == 2) {
            if (lb == null) lb = LifeBlock.getLifeBlock(xx, yy-1);
        }

        if (lb != null) {
            takeFromLifeBlock(lb);
        }
    }

    private void takeFromLifeBlock(LifeBlock lb) {
        if (lb.getLife() > 0) lb.setLife(lb.getLife()-0.01f);
    }


    //Getters and Setters


}
