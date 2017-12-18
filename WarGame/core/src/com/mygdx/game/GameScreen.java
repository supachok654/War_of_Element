package com.mygdx.game;

import java.awt.RenderingHints.Key;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class GameScreen extends ScreenAdapter {

	private WarGame warofelementsGame;
	public World world;
	public WorldRenderer worldRenderer;
	private BitmapFont font;
	public GameScreen(WarGame warofelementsGame) {
		this.warofelementsGame = warofelementsGame;
		world = new World(warofelementsGame);
		worldRenderer = new WorldRenderer(warofelementsGame,world);
	}
	@Override
    public void render(float delta) {
        Gdx.gl.glClearColor(.50f, .230f, .50f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		update(delta);
		worldRenderer.render(delta);
    }
	private void update(float delta) {
		world.update(delta);
	}
}