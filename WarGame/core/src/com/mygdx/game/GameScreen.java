package com.mygdx.game;

import java.awt.RenderingHints.Key;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

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
	public Texture waterminionImg;
	public Texture fireminionImg;
	public Texture bigwaterminionImg;
	public Texture bigfireminionImg;
	public Texture ultrawaterminionImg;
	public Texture ultrafireminionImg;
	private Water water;
	private Fire fire;
	public World world;
	private WaterMinion waterMinion;
	private FireMinion fireMinion;
	private BigWaterMinion bigwaterMinion;
	private BigFireMinion bigfireMinion;
	private UltraWaterMinion ultrawaterMinion;
	private UltraFireMinion ultrafireMinion;
	private List<WaterMinion> waterList;
	private List<FireMinion> fireList;
	private List<BigWaterMinion> bigwaterList;
	private List<BigFireMinion> bigfireList;
	private List<UltraWaterMinion> ultrawaterList;
	private List<UltraFireMinion> ultrafireList;
	//private LinkWaterMinion<> linkWaterMinion;
	private BitmapFont font;
	public GameScreen(WarGame warofelementsGame) {
		this.warofelementsGame = warofelementsGame;
		waterImg = new Texture("pacman.png");
		fireImg = new Texture("pacman.png");
		waterminionImg = new Texture("pacman.png");
		fireminionImg = new Texture("pacman.png");
		bigwaterminionImg = new Texture("bigpacman.png");
		bigfireminionImg = new Texture("bigpacman.png");
		ultrawaterminionImg = new Texture("extrapacman.png");
		ultrafireminionImg = new Texture("extrapacman.png");
		world = new World(warofelementsGame);
		water = world.getWater();
		fire = world.getFire();
		Background = new Texture("background.jpg");
		waterMinion = new WaterMinion(water);
		fireMinion = new FireMinion(fire);
		waterList = new ArrayList();
		//waterList.add(waterMinion);
		fireList = new ArrayList();
		//fireList.add(fireMinion);
		bigwaterMinion = new BigWaterMinion(water);
		bigfireMinion = new BigFireMinion(fire);
		bigwaterList = new ArrayList();
		//bigwaterList.add(bigwaterMinion);
		bigfireList = new ArrayList();
		//bigfireList.add(bigfireMinion);
		ultrawaterMinion = new UltraWaterMinion(water);
		ultrafireMinion = new UltraFireMinion(fire);
		ultrawaterList = new ArrayList();
		//ultrawaterList.add(ultrawaterMinion);
		ultrafireList = new ArrayList();
		//ultrafireList.add(ultrafireMinion);
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
        	batch.draw(waterminionImg,waterList.get(i).getPosition().x,waterList.get(i).getPosition().y);
        }
        for(int i=0;i<fireList.size();i++) {
        	batch.draw(fireminionImg,fireList.get(i).getPosition().x,fireList.get(i).getPosition().y);
        }
        for(int i=0;i<bigwaterList.size();i++) {
        	batch.draw(bigwaterminionImg,waterList.get(i).getPosition().x,waterList.get(i).getPosition().y);
        }
        for(int i=0;i<bigfireList.size();i++) {
        	batch.draw(bigfireminionImg,fireList.get(i).getPosition().x,fireList.get(i).getPosition().y);
        }
        for(int i=0;i<ultrawaterList.size();i++) {
        	batch.draw(ultrawaterminionImg,waterList.get(i).getPosition().x,waterList.get(i).getPosition().y);
        }
        for(int i=0;i<ultrafireList.size();i++) {
        	batch.draw(ultrafireminionImg,fireList.get(i).getPosition().x,fireList.get(i).getPosition().y);
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
			int randomNum_1 = ThreadLocalRandom.current().nextInt(1,8);
			System.out.println(randomNum_1);
			/*if(randomNum_1 < 4) {
				waterList.add(new WaterMinion(water));
				waterList.get(waterList.size()-1).setCheck(1);
				
			}
			else if(randomNum_1 < 7) {
				bigwaterList.add(new BigWaterMinion(water));
				bigwaterList.get(bigwaterList.size()-1).setCheck(1);
				
			}
			else {
				ultrawaterList.add(new UltraWaterMinion(water));
				ultrawaterList.get(ultrawaterList.size()-1).setCheck(1);
				
			}*/
			
		}
		if(Gdx.input.isKeyJustPressed(Keys.LEFT)) {
			
			int randomNum_2 = ThreadLocalRandom.current().nextInt(1,8);
			/*if(randomNum_2 < 4) {
				fireList.add(new FireMinion(fire));
				fireList.get(fireList.size()-1).setCheck(1);
				
			}
			else if(randomNum_2 < 7) {
				bigfireList.add(new BigFireMinion(fire));
				bigfireList.get(bigfireList.size()-1).setCheck(1);
				
			}
			else {
				ultrafireList.add(new UltraFireMinion(fire));
				ultrafireList.get(ultrafireList.size()-1).setCheck(1);
				
			}*/
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
		for(int i=0;i<bigwaterList.size();i++) {
			bigwaterList.get(i).update();
			if(bigwaterList.get(i).getPosition().x>1280) {
				bigwaterList.remove(i);
				world.waterscore++;
			
			}
		}
		for(int i=0;i<bigfireList.size();i++) {
			bigfireList.get(i).update();
			if(bigfireList.get(i).getPosition().x<0) {
				bigfireList.remove(i);
				world.firescore++;
				
			}
		}
		for(int i=0;i<ultrawaterList.size();i++) {
			ultrawaterList.get(i).update();
			if(ultrawaterList.get(i).getPosition().x>1280) {
				ultrawaterList.remove(i);
				world.waterscore++;
			
			}
		}
		for(int i=0;i<ultrafireList.size();i++) {
			ultrafireList.get(i).update();
			if(ultrafireList.get(i).getPosition().x<0) {
				ultrafireList.remove(i);
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
