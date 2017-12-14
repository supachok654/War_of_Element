package com.mygdx.game;

import java.awt.RenderingHints.Key;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class GameScreen extends ScreenAdapter {

	private WarGame warofelementsGame;
	public Texture Background;
	public Texture waterImg;
	public Texture fireImg;
	private Water water;
	private Fire fire;
	private World world;
	
	public GameScreen(WarGame warofelementsGame) {
		this.warofelementsGame = warofelementsGame;
		waterImg = new Texture("pacman.png");
		fireImg = new Texture("pacman.png");
		world = new World(warofelementsGame);
		water = world.getWater();
		fire = world.getFire();
		Background = new Texture("background.jpg");
		//Background = new Texture(Gdx.files.internal("background.jpg"));
	}
	@Override
    public void render(float delta) {
        SpriteBatch batch = warofelementsGame.batch;
        batch.begin();
        batch.draw(Background, 0, 0);
        update(delta);
        Vector2 pos_water = water.getPosition();
        Vector2 pos_fire = fire.getPosition();
        batch.draw(waterImg, pos_water.x, pos_water.y);
        batch.draw(fireImg, pos_fire.x, pos_fire.y);
        
        batch.end();
    }
	private void update(float delta) {
		if(Gdx.input.isKeyJustPressed(Keys.W)){
			
			water.moveUp();
			
		}
		if(Gdx.input.isKeyJustPressed(Keys.S)) {
			
			water.moveDown();
		}
		if(Gdx.input.isKeyJustPressed(Keys.UP)){
			
			fire.moveUp();
			
		}
		if(Gdx.input.isKeyJustPressed(Keys.DOWN)) {
			
			fire.moveDown();
		}
	}
}

