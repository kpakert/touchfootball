package com.me.touchfootball2;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL10;
import com.me.touchfootball2.gui.Screens;

public class TouchFootball2 extends Game {
	
	private FPSLogger fpsLogger;
	
	public Screens screens;
	
	@Override
	public void create() {
		screens = new Screens(this);
		screens.load();
		setScreen(screens.mainMenuScreen);
		fpsLogger = new FPSLogger();
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		fpsLogger.log();
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void resume() {
		super.resume();
	}
	
}
