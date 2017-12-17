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
	private Random rand;
	private Water water;
	private Fire fire;
	public World world;
	private WaterMinion waterMinion;
	private FireMinion fireMinion;
	private List<WaterMinion> waterList;
	private List<FireMinion> fireList;

	private List<Texture> waterlistImg;
	private List<Texture> firelistImg;


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
		waterMinion = new WaterMinion(water,1);
		fireMinion = new FireMinion(fire,1);
		waterList = new ArrayList();
		waterList.add(waterMinion);
		fireList = new ArrayList();
		fireList.add(fireMinion);
		font = new BitmapFont();
		firelistImg = new ArrayList();
		waterlistImg = new ArrayList();
		waterlistImg.add(new Texture("pacman.png"));
		firelistImg.add(new Texture("pacman.png"));
		//rand = new Random();
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
        for(int i=0;i<waterlistImg.size();i++) {
        	batch.draw(waterlistImg.get(i),waterList.get(i).getPosition().x,waterList.get(i).getPosition().y);
        }
        for(int i=0;i<firelistImg.size();i++) {
        	batch.draw(firelistImg.get(i),fireList.get(i).getPosition().x,fireList.get(i).getPosition().y);
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

			int tmp = rand.nextInt(8)+1;
			System.out.println(tmp);
			waterList.get(waterList.size()-1).setCheck(1);
			waterList.add(new WaterMinion(water,tmp));
			if(tmp <= 4)
				waterlistImg.add(new Texture("pacman.png"));
			else if(tmp <= 7)
				waterlistImg.add(new Texture("bigpacman.png"));
			else if(tmp == 8)
				waterlistImg.add(new Texture("extrapacman.png"));
			//int randomNum_1 = ThreadLocalRandom.current().nextInt(1,8);
			//System.out.println(randomNum_1);
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

			int tmp = rand.nextInt(8)+1;
			System.out.println(tmp);
			fireList.get(fireList.size()-1).setCheck(1);
			fireList.add(new FireMinion(fire,tmp));
			if(tmp <= 4)
				firelistImg.add(new Texture("pacman.png"));
			else if(tmp <= 7)
				firelistImg.add(new Texture("bigpacman.png"));
			else if(tmp == 8)
				firelistImg.add(new Texture("extrapacman.png"));
			//int randomNum_2 = ThreadLocalRandom.current().nextInt(1,8);
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
				waterlistImg.remove(i);
				world.waterscore++;
			
			}
		}
		for(int i=0;i<fireList.size();i++) {
			fireList.get(i).update();
			if(fireList.get(i).getPosition().x<0) {
				fireList.remove(i);
				firelistImg.remove(i);
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
