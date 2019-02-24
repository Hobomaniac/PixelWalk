package com.jalenwinslow.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jalenwinslow.game.Handler;
import com.jalenwinslow.game.gameobjects.Map;
import com.jalenwinslow.game.gameobjects.Player;
import com.jalenwinslow.game.utils.Assets;

public class GameState extends State {

    Map map;
    public Player player;

    public GameState(Handler handler) {
        super(handler);
    }

    //Main Methods
    public void init() {
        map = new Map(handler, 0 , 0);
        player = new Player(handler, 2, 2);
    }

    @Override
    public void update(float dt) {
        map.update(dt);
        player.update(dt);
    }

    @Override
    public void render(SpriteBatch batch) {
        //batch.draw(Assets.mapT, 0, 0);
        map.render(batch);
        player.render(batch);
    }

    @Override
    public void dispose() {
        player.dispose();
        map.dispose();
    }

    //Getters and Setters

}
