package com.jalenwinslow.game.gameobjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.jalenwinslow.game.Handler;

public class LifeBlock extends GameObject {

    public static Array<LifeBlock> lifeBlocks = new Array<LifeBlock>();

    private Texture t;
    private int vecX, vecY;
    private float life;

    public LifeBlock(Handler handler, float x, float y) {
        super(handler, x, y);
        init();
    }

    public void init() {
        Pixmap p = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        p.setColor(Color.BLUE);
        p.drawPixel(0,0);
        t = new Texture(p);
        life = 1f;
    }

    @Override
    public void update(float dt) {
        checkDeath();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.setColor(1, 1, 1, life);
        batch.draw(t, x, y);
        batch.setColor(1, 1, 1, 1);
    }

    @Override
    public void dispose() {
        t.dispose();
    }

    //Other methods
    public static void updateLifeBlocks(float dt) {
        for (LifeBlock lb : lifeBlocks) {
            if (lb != null) lb.update(dt);
        }
    }

    public static void renderLifeBlocks(SpriteBatch batch) {
        for (LifeBlock lb : lifeBlocks) {
            if (lb != null) lb.render(batch);
        }
    }

    public static void disposeLifeBlocks() {
        for (LifeBlock lb : lifeBlocks) {
            if (lb != null) lb.dispose();
        }
        lifeBlocks = null;
    }

    public static void addLifeBlock(LifeBlock lb) {
        lifeBlocks.add(lb);
    }

    public static LifeBlock getLifeBlock(int x, int y) {
        LifeBlock lb = null;
        for (int i = 0; i < lifeBlocks.size; i++) {
            if (lifeBlocks.get(i).x == x && lifeBlocks.get(i).y == y) {
                lb = lifeBlocks.get(i);
                break;
            }
        }
        return lb;
    }

    public void checkDeath() {
        if (life <= 0) {
            handler.getGameState().getMap().setPositionEmpty((int)x, (int)y);
            LifeBlock.lifeBlocks.removeValue(this, true);
        }
    }

    //Getters and Setters
    public float getLife() {return life;}

    public void setLife(float life) {this.life = life;}

}
