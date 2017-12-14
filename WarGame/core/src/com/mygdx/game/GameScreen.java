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
	public Texture bulletImg;
	private Water water;
	private Fire fire;
	public World world;
	private LinkWaterMinion w;
	private WaterMinion waterMinion;
	private FireMinion fireMinion;
	
	public GameScreen(WarGame warofelementsGame) {
		this.warofelementsGame = warofelementsGame;
		waterImg = new Texture("pacman.png");
		fireImg = new Texture("pacman.png");
		bulletImg = new Texture("pacman.png");
		world = new World(warofelementsGame);
		water = world.getWater();
		fire = world.getFire();
		Background = new Texture("background.jpg");
		waterMinion = new WaterMinion(water);
		fireMinion = new FireMinion(fire);
		//w = new LinkWaterMinion(this);
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
        batch.draw(bulletImg,waterMinion.getPosition().x,waterMinion.getPosition().y);
        batch.draw(bulletImg,fireMinion.getPosition().x,fireMinion.getPosition().y);
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
		if(Gdx.input.isKeyJustPressed(Keys.D)) {
			
			waterMinion.setCheck(1);
		}
		if(Gdx.input.isKeyJustPressed(Keys.LEFT)) {
			
			fireMinion.setCheck(1);
		}
		waterMinion.update();
		fireMinion.update();
		/*if(Gdx.input.isKeyJustPressed(Keys.D)) {
			check =1;
		}*/
	}
}

