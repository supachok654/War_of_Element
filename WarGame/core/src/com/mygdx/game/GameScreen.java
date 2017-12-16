package com.mygdx.game;

import java.awt.RenderingHints.Key;
import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
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
	private WaterMinion waterMinion;
	private FireMinion fireMinion;
	private List<WaterMinion> waterList;
	private List<FireMinion> fireList;
	//private LinkWaterMinion<> linkWaterMinion;
	private BitmapFont font;
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
		waterList = new ArrayList();
		waterList.add(waterMinion);
		fireList = new ArrayList();
		fireList.add(fireMinion);
		font = new BitmapFont();
		
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
        font.draw(batch,"WATER : " + world.getWaterScore(),300,770);
        font.draw(batch,"FIRE : " + world.getFireScore(),960,770);
        for(int i=0;i<waterList.size();i++) {
        	batch.draw(bulletImg,waterList.get(i).getPosition().x,waterList.get(i).getPosition().y);
        }
        for(int i=0;i<fireList.size();i++) {
        	batch.draw(bulletImg,fireList.get(i).getPosition().x,fireList.get(i).getPosition().y);
        }
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
			
			waterList.get(waterList.size()-1).setCheck(1);
			waterList.add(new WaterMinion(water));
			
		}
		if(Gdx.input.isKeyJustPressed(Keys.LEFT)) {
			
			fireList.get(fireList.size()-1).setCheck(1);
			fireList.add(new FireMinion(fire));
		}
		for(int i=0;i<waterList.size();i++) {
			waterList.get(i).update();
			if(waterList.get(i).getPosition().x>1280) {
				waterList.remove(i);
				world.waterscore++;
			
			}
		}
		for(int i=0;i<fireList.size();i++) {
			fireList.get(i).update();
			if(fireList.get(i).getPosition().x<0) {
				fireList.remove(i);
				world.firescore++;
				
			}
		}
		//fireMinion.update();
		//System.out.println(waterList.size());
		//System.out.println(waterScore);
		//System.out.println(fireScore);
		/*if(Gdx.input.isKeyJustPressed(Keys.D)) {
			check =1;
		}*/
	}
}

