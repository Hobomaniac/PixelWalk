package com.jalenwinslow.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jalenwinslow.game.utils.Assets;
import com.jalenwinslow.game.utils.CameraHandler;

public class Main extends ApplicationAdapter {
	SpriteBatch batch;
	Handler handler;
	OrthographicCamera cam;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		cam = new OrthographicCamera(CameraHandler.CAMERA_WIDTH, CameraHandler.CAMERA_HEIGHT);
		CameraHandler.cam = cam;
		cam.position.set(cam.viewportWidth / 2f, cam.viewportHeight / 2f, 0);
		cam.update();
		handler = new Handler(this, cam);
		handler.init();
	}

	@Override
	public void render () {

		handler.update(Gdx.graphics.getDeltaTime());

		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		cam.update();
		batch.setProjectionMatrix(cam.combined);
		batch.begin();
		handler.render(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		handler.dispose();
		Assets.dispose();
		batch.dispose();
	}
}
